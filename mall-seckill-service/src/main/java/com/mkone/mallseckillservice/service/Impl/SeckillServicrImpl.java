package com.mkone.mallseckillservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkone.mallseckillservice.fegin.ProductFeginService;
import com.mkone.mallseckillservice.service.SeckillService;
import com.mkone.ommonservice.bo.SeckillTimeProductBo;
import com.mkone.ommonservice.dao.PmsSeckillDao;
import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.entity.PmsSeckill;
import com.mkone.ommonservice.util.R;
import com.alibaba.fastjson.TypeReference;
import com.mkone.ommonservice.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service("SeckillService")
public class SeckillServicrImpl extends ServiceImpl<PmsSeckillDao, PmsSeckill> implements SeckillService {
    @Resource
    ProductFeginService feginService;

    @Override
    public R getSeckillProduct() {
        QueryWrapper<PmsSeckill> queryWrapper = new QueryWrapper<PmsSeckill>().between("seckill_time", TimeUtil.getStartTime(), TimeUtil.getEndTime());
        List<PmsSeckill> pmsSeckillList = this.list(queryWrapper);
        List<SeckillTimeProductBo> collect = pmsSeckillList.stream().map(item -> {
            SeckillTimeProductBo seckillTimeProductBo = new SeckillTimeProductBo();
            BeanUtils.copyProperties(item,seckillTimeProductBo);
            R r = feginService.info(Long.valueOf(item.getSeckillProId()));
            if (r.getCode() == 0) {
                PmsProduct pmsProduct = r.getData(new TypeReference<PmsProduct>() {
                });
                BeanUtils.copyProperties(pmsProduct,seckillTimeProductBo);
                return seckillTimeProductBo;
            }
            return null;
        }).collect(Collectors.toList());
        if (collect.isEmpty()) {
            return R.error(500, "没有该商品，秒杀失败");
        }
        collect.stream().forEach(item ->log.info(String.valueOf(item)));

        return null;
    }


}
