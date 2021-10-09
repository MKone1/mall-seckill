package com.mkone.mallseckillservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@EnableDiscoveryClient
@EnableRabbit
@SpringBootApplication
@MapperScan("com.mkone.ommonservice.dao")
//出现fegin接口无法注入，在启动类中指定fegin接口所在包
@EnableFeignClients(basePackages = "com.mkone.mallseckillservice.fegin")
public class MallSeckillServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSeckillServiceApplication.class, args);
    }

}
