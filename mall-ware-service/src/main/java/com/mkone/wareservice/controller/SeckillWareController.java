package com.mkone.wareservice.controller;

import com.mkone.ommonservice.entity.WmsWareSku;
import com.mkone.ommonservice.util.R;
import com.mkone.ommonservice.vo.SeckillWarelLockdVo;
import com.mkone.wareservice.service.SeckillWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ware")
public class SeckillWareController {

    @Autowired
    SeckillWareService seckillWareService;
    @RequestMapping("/list")
    public R list(){
        List<WmsWareSku> wareSkuList = seckillWareService.list();
        return R.ok().setData(wareSkuList);
    }

    @RequestMapping("/update/stock/locked")
    public R updateStockLock(@RequestBody SeckillWarelLockdVo vo){
        try {
            Boolean lock = seckillWareService.orderStockLock(vo);
            return R.ok("success");
        }catch (Exception e){
            return R.error("锁库存失败");
        }
    }

}
