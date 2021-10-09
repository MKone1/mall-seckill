package com.mkone.commodityservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.mkone.commodityservice.service.CommondityService;
import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.entity.PmsSeckill;
import com.mkone.ommonservice.util.R;
import com.mkone.ommonservice.util.TimeUtil;
import com.mkone.ommonservice.vo.SeckillProductHomeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/list")
    public R list(@RequestBody JSONObject jsonObject) {
        List<PmsProduct> list = commondityService.list();
        list.stream().forEach((item) -> logger.info(String.valueOf(item)));
        return R.ok("success").setData(list);
    }

    @RequestMapping("/info/{productId}")
    public R info(@PathVariable("productId") Long productId) {
        logger.info("查询的ID"+productId);
       PmsProduct product = commondityService.getById(productId);
        return R.ok("success").setData(product);
    }

    /**
     * 首页中秒杀预约展示
     * @return
     */
    @RequestMapping("/get/seckill")
    public R getSeckillInfo(){
      List<SeckillProductHomeVo> seckillProductHomeVoList =  commondityService.getSeckill();
      return null;
    }

}
