package com.mkone.mallauthservice.feign;

import com.mkone.ommonservice.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 获取token
 */
@FeignClient("mall-security-service")
public interface SecurityFeignService {
    @PostMapping(value = "/oauth/token")
    R getAccessToken(@RequestParam Map<String, String> parameters);
}
