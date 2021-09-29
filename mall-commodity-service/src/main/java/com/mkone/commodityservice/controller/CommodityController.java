package com.mkone.commodityservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.mkone.commodityservice.service.CommondityService;
import com.mkone.ommonservice.constant.SeckillConstant;
import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.entity.PmsSeckill;
import com.mkone.commodityservice.fegin.SeckillFeginService;
import com.mkone.ommonservice.util.R;
import com.mkone.ommonservice.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.TypeReference;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class CommodityController {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);
    @Autowired
    CommondityService commondityService;
    @Resource
    SeckillFeginService seckillFeginService;
    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/list")
    public R list(@RequestBody JSONObject jsonObject) {
        List<PmsProduct> list = commondityService.list();
        list.stream().forEach((item) -> logger.info(String.valueOf(item)));
        return R.ok("success").setData(list);
    }

    @RequestMapping("/info")
    public R info(@RequestBody PmsProduct product) {
        product = commondityService.getById(product.getId());
        return R.ok("success").setData(product);
    }

    @RequestMapping("/getSeckill")
    public R getSeckill() {
        R list = seckillFeginService.list();
        if (list.getCode() == 0) {
            TypeReference<List<PmsSeckill>> listTypeReference = new TypeReference<List<PmsSeckill>>() {
            };
            List<PmsSeckill> collect = list.getData(listTypeReference).stream().collect(Collectors.toList());
            for (PmsSeckill pmsSeckill : collect) {
                if (TimeUtil.compareTwoDate(TimeUtil.addDays(pmsSeckill.getSeckillTime(),1), new Date()) == 0) {
                    //提前一天将商品加入缓存
                    redisTemplate.opsForHash().put("seckill:session",pmsSeckill.getSeckillEndTime(),pmsSeckill.getSeckillProId());
                }
            }

        } else {
            return R.error("没有秒杀商品");
        }
        return R.ok("success").setData(list);
    }
}
