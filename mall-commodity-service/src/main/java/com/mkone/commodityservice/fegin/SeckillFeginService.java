package com.mkone.commodityservice.fegin;

import com.mkone.ommonservice.util.R;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PostMapping;
@FeignClient(name = "mall-seckill-service")
public interface SeckillFeginService {
    @PostMapping("/seckill/list")
    R list();
}
