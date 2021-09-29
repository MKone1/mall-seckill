package com.mkone.commodityservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.mkone.commodityservice.service.CommondityService;
import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class CommodityController {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);
    @Autowired
    CommondityService commondityService;

    @RequestMapping("/list")
    public R list(@RequestBody JSONObject jsonObject){
        List<PmsProduct> list = commondityService.list();
        list.stream().forEach((item)->logger.info(String.valueOf(item)));
        return R.ok("success").setData(list);
    }
    @RequestMapping("/info")
    public R info(@RequestBody PmsProduct product){
         product = commondityService.getById(product.getId());
         return R.ok("success").setData(product);
    }
}
