package com.mkone.commodityservice;

import com.mkone.ommonservice.constant.SeckillConstant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
class MallCommodityServiceApplicationTests {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        String key = "hash";
        redisTemplate.opsForHash().put(key,"key","value");
        Boolean hasKey = redisTemplate.opsForHash().hasKey(key, "key");
        System.out.println("是否有参"+hasKey);
        Object key1 = redisTemplate.opsForHash().get(key, "key");
        System.out.println(key1);

    }

}
