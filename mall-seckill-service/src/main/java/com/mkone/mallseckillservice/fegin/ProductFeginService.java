package com.mkone.mallseckillservice.fegin;

import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.util.R;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
@Component
@FeignClient(value = "mall-commodity-service")
public interface ProductFeginService {
    @RequestMapping(value = "/product/info/{productId}")
     R info(@PathVariable("productId") Long productId);
}
