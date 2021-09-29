package com.mkone.commodityservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkone.commodityservice.service.CommondityService;
import com.mkone.ommonservice.dao.PmsProductDao;
import com.mkone.ommonservice.entity.PmsProduct;
import org.springframework.stereotype.Service;

@Service("CommondityService")
public class CommodityServiceImpl extends ServiceImpl<PmsProductDao,PmsProduct> implements CommondityService {
}
