package com.mkone.mallseckillservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mkone.ommonservice.dao.PmsSeckillDao;
import com.mkone.ommonservice.entity.PmsSeckill;
import com.mkone.ommonservice.util.R;
import com.mkone.ommonservice.vo.SeckillActivitVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeckillService extends IService<PmsSeckill> {
    /**
     * 上架秒杀商品，秒杀详情页进行展示
     * @return
     */
   R getSeckillProduct();

    /**
     * 增加秒杀活动
     * @param activitVo
     */
    R addActivity(PmsSeckill activitVo);
}
