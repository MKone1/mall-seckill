package com.mkone.wareservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkone.ommonservice.dao.WmsWareSkuDao;
import com.mkone.ommonservice.entity.WmsWareSku;
import com.mkone.ommonservice.vo.SeckillWarelLockdVo;
import com.mkone.wareservice.service.SeckillWareService;
import org.springframework.stereotype.Service;

@Service("SeckillWareService")
public class SeckillWareServiceImpl extends ServiceImpl<WmsWareSkuDao, WmsWareSku> implements SeckillWareService {
    @Override
    public Boolean orderStockLock(SeckillWarelLockdVo vo) {
        return null;
    }
}
