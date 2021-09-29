package com.mkone.commodityservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableRabbit
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.mkone.ommonservice.dao")
public class MallCommodityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallCommodityServiceApplication.class, args);
    }

}
