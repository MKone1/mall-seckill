package com.mkone.mallseckillservice.controller;

import com.mkone.mallseckillservice.service.SeckillService;
import com.mkone.ommonservice.entity.PmsSeckill;
import com.mkone.ommonservice.util.R;
import com.mkone.ommonservice.vo.SeckillActivitVo;
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

    /**
     * 查询所有的秒杀活动
     *
     * @return
     */
    @RequestMapping("/list")
    public R list() {
        List<PmsSeckill> list =
                seckillService.list();
        R seckillProduct = seckillService.getSeckillProduct();
        return R.ok("success").setData(list);
    }

    @RequestMapping("/add")
    public R addSeckillActivity(@RequestBody PmsSeckill pmsSeckill) {

        return seckillService.addActivity(pmsSeckill);
    }


}
