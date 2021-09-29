package com.mkone.mallseckillservice.controller;

import com.mkone.mallseckillservice.service.SeckillService;
import com.mkone.ommonservice.entity.PmsSeckill;
import com.mkone.ommonservice.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seckill")
public class SeckillController {
    @Autowired
    SeckillService seckillService;
    @RequestMapping("/list")
    public R list(){
        List<PmsSeckill> list =
                seckillService.list();
        return R.ok("success").setData(list);
    }

}
