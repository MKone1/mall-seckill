package com.mkone.wareservice;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableRabbit
@SpringBootApplication
@MapperScan({"com.mkone.ommonservice.dao.WmsWareSkuDao","com.mkone.ommonservice.dao.WmsWareInfoDao"})

public class MallWareServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWareServiceApplication.class, args);
    }

}
