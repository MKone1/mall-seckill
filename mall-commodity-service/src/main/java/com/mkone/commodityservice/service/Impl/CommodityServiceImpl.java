package com.mkone.commodityservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkone.commodityservice.service.CommondityService;
import com.mkone.ommonservice.constant.SeckillConstant;
import com.mkone.ommonservice.dao.PmsProductDao;
import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.entity.PmsSeckill;
import com.mkone.ommonservice.util.TimeUtil;
import com.mkone.ommonservice.vo.SeckillProductActivityVo;
import com.mkone.ommonservice.vo.SeckillProductHomeVo;
import com.mkone.ommonservice.vo.SekillTimeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("CommondityService")
public class CommodityServiceImpl extends ServiceImpl<PmsProductDao, PmsProduct> implements CommondityService {
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 流程：缓存中查询下一个时间段的秒杀商品
     *
     * @return
     */
    @Override
    public List<SeckillProductHomeVo> getSeckill() {
        //获取当前时间，计算下个时间端的时间，在缓存中进行查询
        BoundHashOperations hashOps = redisTemplate.boundHashOps(SeckillConstant.SESSION_CACHE_PREFIX);
        Boolean aBoolean = true;
        Map<String, Date> nextTime = TimeUtil.getNextTime();
        String key = nextTime.get("startData").getTime()+"_"+nextTime.get("endData").getTime();
        aBoolean = hashOps.hasKey(key);
        if (!aBoolean){
            //当前时间，下一时间节点没有秒杀商品
            return null;
        }
        List<String> seckillInfo =(List<String>) redisTemplate.opsForHash().get(SeckillConstant.SESSION_CACHE_PREFIX, key);
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

        return collect;
    }

    @Override
    public List<SeckillProductActivityVo> getSeckillActivityInfo(SekillTimeVo seckillTimeVo) {
        if (seckillTimeVo.getTimes()!=null&&seckillTimeVo.getTimes()!=0){
            Map<String, Long> nowTime = TimeUtil.getNowTime();
            String key = nowTime.get("startData")+"_"+nowTime.get("endData");
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
        return null;
    }
}
