package com.mkone.commodityservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.vo.SeckillProductHomeVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommondityService extends IService<PmsProduct> {
    /**
     * 首页中秒杀预约展示
     * @return
     */
    List<SeckillProductHomeVo> getSeckill();
}
