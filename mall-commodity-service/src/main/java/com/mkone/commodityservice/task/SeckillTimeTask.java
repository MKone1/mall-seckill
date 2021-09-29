package com.mkone.commodityservice.task;
import com.alibaba.fastjson.TypeReference;
import com.mkone.commodityservice.fegin.SeckillFeginService;
import com.mkone.ommonservice.entity.PmsSeckill;
import com.mkone.ommonservice.util.R;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 秒杀商品上线定时器
 */
@Component
public class SeckillTimeTask {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    SeckillFeginService seckillFeginService;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Scheduled(cron = "*/15 * * * * ?")
    public void seckillTask(){
        R r = seckillFeginService.list();
        if (r.getCode() == 0){
            TypeReference<List<PmsSeckill>> listTypeReference = new TypeReference<List<PmsSeckill>>(){};
            r.getData(listTypeReference).stream().forEach(item ->logger.info(String.valueOf(item)));
        }
    }
}
