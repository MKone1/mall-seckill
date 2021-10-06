package com.mkone.mallseckillservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mkone.ommonservice.dao.PmsSeckillDao;
import com.mkone.ommonservice.entity.PmsSeckill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeckillService extends IService<PmsSeckill> {
    /**
     * 上架秒杀商品，秒杀详情页进行展示
     * @return
     */
    List<PmsSeckill> getSeckillProduct();
}
