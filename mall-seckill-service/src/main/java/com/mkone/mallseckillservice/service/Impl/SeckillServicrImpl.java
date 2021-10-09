package com.mkone.mallseckillservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkone.mallseckillservice.fegin.ProductFeginService;
import com.mkone.mallseckillservice.service.SeckillService;
import com.mkone.ommonservice.bo.SeckillTimeProductBo;
import com.mkone.ommonservice.constant.SeckillConstant;
import com.mkone.ommonservice.dao.PmsSeckillDao;
import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.entity.PmsSeckill;
import com.mkone.ommonservice.util.R;
import com.alibaba.fastjson.TypeReference;
import com.mkone.ommonservice.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

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

    //    private static BoundHashOperations<String, String, String> ops = redisTemplate.boundHashOps(SESSION_CACHE_PREFIX);
    @Override
    public R getSeckillProduct() {
        QueryWrapper<PmsSeckill> queryWrapper = new QueryWrapper<PmsSeckill>().between("seckill_time", TimeUtil.getStartTime(), TimeUtil.getEndTime());
        List<PmsSeckill> pmsSeckillList = this.list(queryWrapper);
        if (pmsSeckillList.isEmpty()) {
            return null;
        }
        pmsSeckillList.forEach(this::accept);
        return R.ok();
    }


    private void accept(PmsSeckill item) {
        String key = item.getSeckillActivitId() + "_" + item.getSeckillTime() + "_" + item.getSeckillEndTime();
        String value = item.getSeckillProId() + "_" + item.getSeckillProId();
        redisTemplate.opsForHash().put(SeckillConstant.SESSION_CACHE_PREFIX, key, value);
    }
}
