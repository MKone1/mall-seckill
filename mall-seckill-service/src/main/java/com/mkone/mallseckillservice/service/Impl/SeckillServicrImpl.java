package com.mkone.mallseckillservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkone.mallseckillservice.fegin.ProductFeginService;
import com.mkone.mallseckillservice.service.SeckillService;
import com.mkone.ommonservice.dao.PmsSeckillDao;
import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.entity.PmsSeckill;
import com.mkone.ommonservice.util.R;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service("SeckillService")
public class SeckillServicrImpl extends ServiceImpl<PmsSeckillDao, PmsSeckill> implements SeckillService {
    @Resource
    ProductFeginService feginService;

    @Override
    public List<PmsSeckill> getSeckillProduct() {
        QueryWrapper<PmsSeckill> queryWrapper = new QueryWrapper<PmsSeckill>().between("seckill_time", getStartTime(), getEndTime());
        List<PmsSeckill> pmsSeckillList = this.list(queryWrapper);
        pmsSeckillList.stream().map(session -> {
            R r = feginService.info(session.getSeckillProId());
            if (r.getCode() == 0) {
                PmsProduct pmsProduct = r.getData(new TypeReference<PmsProduct>() {});
                return pmsProduct;
            }
            return null;
        }).collect(Collectors.toList());
        return null;
    }


    //当前天数的 00:00:00
    private String getStartTime() {
        LocalDate now = LocalDate.now();
        LocalDateTime time = now.atTime(LocalTime.MIN);
        String format = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return format;
    }

    //当前天数+2 23:59:59..
    private String getEndTime() {
        LocalDate now = LocalDate.now();
        LocalDateTime time = now.plusDays(2).atTime(LocalTime.MAX);
        String format = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return format;
    }

}
