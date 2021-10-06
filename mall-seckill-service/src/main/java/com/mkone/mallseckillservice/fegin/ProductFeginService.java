package com.mkone.mallseckillservice.fegin;

import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("mall-commodity-service")
public interface ProductFeginService {
    @RequestMapping("/product/info")
    public R info(@RequestBody Integer productId);
}
