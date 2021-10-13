package com.mkone.mallseckillservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkone.mallseckillservice.fegin.ProductFeginService;
import com.mkone.mallseckillservice.service.SeckillService;
import com.mkone.ommonservice.bo.SeckillTimeProductBo;
import com.mkone.ommonservice.constant.SeckillConstant;
import com.mkone.ommonservice.dao.PmsSeckillActivitDao;
import com.mkone.ommonservice.dao.PmsSeckillDao;
import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.entity.PmsSeckill;
import com.mkone.ommonservice.entity.PmsSeckillActivit;
import com.mkone.ommonservice.util.R;
import com.alibaba.fastjson.TypeReference;
import com.mkone.ommonservice.util.SnowFlakeId;
import com.mkone.ommonservice.util.TimeUtil;
import com.mkone.ommonservice.vo.SeckillActivitVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service("SeckillService")
public class SeckillServicrImpl extends ServiceImpl<PmsSeckillDao, PmsSeckill> implements SeckillService {
    @Resource
    ProductFeginService feginService;
    @Autowired
    RedisTemplate redisTemplate;
    @Resource
    PmsSeckillActivitDao pmsSeckillActivitDao;

    //    private static BoundHashOperations<String, String, String> ops = redisTemplate.boundHashOps(SESSION_CACHE_PREFIX);
    @Override
    public R getSeckillProduct() {
        QueryWrapper<PmsSeckill> queryWrapper = new QueryWrapper<PmsSeckill>().between("seckill_time", TimeUtil.getStartTime(), TimeUtil.getEndTime())
                .between("seckill_end_time",TimeUtil.getStartTime(),TimeUtil.getEndTime());
        List<PmsSeckill> pmsSeckillList = this.list(queryWrapper);
        if (pmsSeckillList.isEmpty()) {
            return null;
        }
        pmsSeckillList.forEach(this::accept);
        return R.ok();
    }

    @Override
    @Transactional
    public R addActivity(PmsSeckill pmsSeckill) {
        long activityId = new SnowFlakeId().nextId();
        if (pmsSeckill!=null){
            pmsSeckill.setSeckillActivitId(activityId);
            this.save(pmsSeckill);
        }
        PmsSeckillActivit activit = new PmsSeckillActivit(pmsSeckill.getSeckillActivitId(), pmsSeckill.getSeckillTime(), pmsSeckill.getSeckillEndTime());
        int insert = pmsSeckillActivitDao.insert(activit);
        if (insert>0){
            return R.ok("success");
        }
        return R.error("fail");
    }

    @Override
    public R getSeckillSkuInfo(Long skuId) {


    return null;
    }

    private void accept(PmsSeckill item) {
        QueryWrapper<PmsSeckill> eq = new QueryWrapper<PmsSeckill>().eq("seckill_time", item.getSeckillTime()).eq("seckill_end_time", item.getSeckillEndTime());
        List<PmsSeckill> list = this.list(eq);
        List<String> collect = list.stream().map(seckill -> {
            String seckillSession = seckill.getSeckillProId() + "_" + seckill.getSeckillNum() + "_" + seckill.getSeckillPrice();
            return seckillSession;
        }).collect(Collectors.toList());
        String key = item.getSeckillTime().getTime() + "_" + item.getSeckillEndTime().getTime();
        redisTemplate.opsForHash().put(SeckillConstant.SESSION_CACHE_PREFIX, key, collect);
    }
}
