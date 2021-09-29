package com.mkone.mallseckillservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkone.mallseckillservice.service.SeckillService;
import com.mkone.ommonservice.dao.PmsSeckillDao;
import com.mkone.ommonservice.entity.PmsSeckill;
import org.springframework.stereotype.Service;

@Service("SeckillService")
public class SeckillServicrImpl extends ServiceImpl<PmsSeckillDao, PmsSeckill>  implements SeckillService {
}
