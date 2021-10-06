package com.mkone.wareservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mkone.ommonservice.entity.WmsWareSku;
import com.mkone.ommonservice.vo.SeckillWarelLockdVo;
import org.springframework.stereotype.Service;

@Service
public interface SeckillWareService extends IService<WmsWareSku> {
    Boolean orderStockLock(SeckillWarelLockdVo vo);
}
