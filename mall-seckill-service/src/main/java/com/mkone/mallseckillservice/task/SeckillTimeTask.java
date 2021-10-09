package com.mkone.mallseckillservice.task;

import com.alibaba.fastjson.TypeReference;
import com.mkone.mallseckillservice.service.SeckillService;
import com.mkone.ommonservice.entity.PmsSeckill;
import com.mkone.ommonservice.util.R;
import com.mkone.ommonservice.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 秒杀商品上线定时器
 */
@Component
public class SeckillTimeTask {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    SeckillService seckillService;
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 每天三点定时，定时上架秒杀商品
     */
    @Scheduled(cron = "0 0 3 * * ?")
    public void seckillTask() {
        List<PmsSeckill> list = seckillService.list();
        if (list.size()!=0||list!=null) {
          R seckillList =   seckillService.getSeckillProduct();

        }
    }

}
