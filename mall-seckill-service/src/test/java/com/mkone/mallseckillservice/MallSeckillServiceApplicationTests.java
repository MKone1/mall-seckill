package com.mkone.mallseckillservice;

import com.alibaba.fastjson.TypeReference;
import com.mkone.mallseckillservice.fegin.ProductFeginService;
import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.util.R;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
class MallSeckillServiceApplicationTests {
    @Autowired
    ProductFeginService productFeginService;
    @Test
    void contextLoads() {
        R info = productFeginService.info(29L);
        if (info.getCode()==0){
            PmsProduct data = info.getData(new TypeReference<PmsProduct>() {
            });
           log.info(String.valueOf(data));
        }
    }

}
