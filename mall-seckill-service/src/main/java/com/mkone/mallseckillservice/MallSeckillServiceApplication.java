package com.mkone.mallseckillservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableRabbit
@SpringBootApplication
@MapperScan("com.mkone.ommonservice.dao")
public class MallSeckillServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSeckillServiceApplication.class, args);
    }

}
