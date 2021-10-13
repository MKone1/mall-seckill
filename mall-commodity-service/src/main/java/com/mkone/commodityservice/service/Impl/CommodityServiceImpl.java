package com.mkone.commodityservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkone.commodityservice.service.CommondityService;
import com.mkone.ommonservice.constant.SeckillConstant;
import com.mkone.ommonservice.dao.PmsProductDao;
import com.mkone.ommonservice.dao.PmsSeckillActivitDao;
import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.entity.PmsSeckill;
import com.mkone.ommonservice.entity.PmsSeckillActivit;
import com.mkone.ommonservice.util.R;
import com.mkone.ommonservice.util.TimeUtil;
import com.mkone.ommonservice.vo.SeckillProductActivityVo;
import com.mkone.ommonservice.vo.SeckillProductHomeVo;
import com.mkone.ommonservice.vo.SekillTimeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service("CommondityService")
public class CommodityServiceImpl extends ServiceImpl<PmsProductDao, PmsProduct> implements CommondityService {
    @Autowired
    RedisTemplate redisTemplate;
    @Resource
    PmsSeckillActivitDao pmsSeckillActivitDao;

    /**
     * 流程：缓存中查询下一个时间段的秒杀商品
     *
     * @return
     */
    @Override
    public R getSeckill() {
        //获取当前时间，计算下个时间端的时间，在缓存中进行查询
        BoundHashOperations hashOps = redisTemplate.boundHashOps(SeckillConstant.SESSION_CACHE_PREFIX);
        Boolean aBoolean = true;
        Map<String, Date> nextTime = TimeUtil.getNextTime();
        String key = nextTime.get("startData").getTime() + "_" + nextTime.get("endData").getTime();
        aBoolean = hashOps.hasKey(key);
        if (!aBoolean) {
            //当前时间，下一时间节点没有秒杀商品
            return null;
        }
        List<String> seckillInfo = (List<String>) redisTemplate.opsForHash().get(SeckillConstant.SESSION_CACHE_PREFIX, key);
        List<SeckillProductHomeVo> collect = seckillInfo.stream().map(string -> {
            String[] split = string.split("_");
            SeckillProductHomeVo productHomeVo = new SeckillProductHomeVo();
            PmsProduct product = this.getById(split[0]);
            productHomeVo.setProductName(product.getName());
            productHomeVo.setProductPic(product.getPic());
            productHomeVo.setSeckillPrice(new BigDecimal(split[2]));
            productHomeVo.setSeckillNum(Integer.valueOf(split[1]));
            return productHomeVo;
        }).collect(Collectors.toList());

        return R.ok("success").setData(collect);
    }

    /**
     * 具体流程：
     * 1，根据前端传递的当前毫秒数，查询出当前时间段正在秒杀的商品
     * 2，根据秒杀场次的活动ID，查询出对应时间段的秒杀商品
     *
     * @param seckillTimeVo
     * @return
     */
    @Override
    public R getSeckillActivityInfo(SekillTimeVo seckillTimeVo) {
        Map map = new HashMap();
        if (seckillTimeVo.getTimes() != null && seckillTimeVo.getTimes() != 0) {
            //获取当前时间段正在秒杀的商品
            Map<String, Long> nowTime = TimeUtil.getNowTime();
            String key = nowTime.get("startData") + "_" + nowTime.get("endData");
            List<SeckillProductActivityVo> collect = getSeckillProductActivityVos(key);
            map.put("nowSeckillLists", collect);
        }
        if (seckillTimeVo.getActivityId() != null && seckillTimeVo.getActivityId() != 0) {
            //查询其他活动场次的秒杀商品
            /**
             * 1,判断传递的活动场次是不是当前时间段
             */
            Long activityId = seckillTimeVo.getActivityId();
            PmsSeckillActivit pmsSeckillActivit = pmsSeckillActivitDao.selectById(activityId);
            long nowTime = new Date().getTime();
            if (nowTime <= pmsSeckillActivit.getSeckillEndTime().getTime() && nowTime >= pmsSeckillActivit.getSeckillTime().getTime()) {
                //活动ID处于当前时间段
                return R.ok("success").setData(map);
            }
            //缓存查询其他秒杀商品
            String key = pmsSeckillActivit.getSeckillTime().getTime()+"_"+pmsSeckillActivit.getSeckillEndTime().getTime();
            List<SeckillProductActivityVo> seckillProductActivityVos = getSeckillProductActivityVos(key);
            map.put("otherGroup",seckillProductActivityVos);
        }
        return R.ok("success").setData(map);
    }

    /**
     *
     * @param key
     * @return
     */
    private List<SeckillProductActivityVo> getSeckillProductActivityVos(String key) {
        List<String> stringList = (List<String>) redisTemplate.opsForHash().get(SeckillConstant.SESSION_CACHE_PREFIX, key);
        List<SeckillProductActivityVo> collect = stringList.stream().map(item -> {
            String[] strings = item.split("_");
            SeckillProductActivityVo activityVo = new SeckillProductActivityVo();
            PmsProduct product = this.getById(strings[0]);
            activityVo.setDescription(product.getDescription());
            activityVo.setSeckillNum(Integer.valueOf(strings[1]));
            activityVo.setProductName(product.getName());
            activityVo.setSeckillPrice(new BigDecimal(strings[2]));
            activityVo.setProductPic(product.getPic());
            return activityVo;
        }).collect(Collectors.toList());
        return collect;
    }
}
