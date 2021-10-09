package com.mkone.commodityservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkone.commodityservice.service.CommondityService;
import com.mkone.ommonservice.dao.PmsProductDao;
import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.vo.SeckillProductHomeVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommondityService")
public class CommodityServiceImpl extends ServiceImpl<PmsProductDao,PmsProduct> implements CommondityService {
    /**
     * 流程：缓存中查询两小时之内的秒杀商品
     * @return
     */
    @Override
    public List<SeckillProductHomeVo> getSeckill() {



        return null;
    }
}
