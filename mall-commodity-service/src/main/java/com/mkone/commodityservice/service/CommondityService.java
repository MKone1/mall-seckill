package com.mkone.commodityservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.util.R;
import com.mkone.ommonservice.vo.SeckillProductActivityVo;
import com.mkone.ommonservice.vo.SeckillProductHomeVo;
import com.mkone.ommonservice.vo.SekillTimeVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommondityService extends IService<PmsProduct> {
    /**
     * 首页中秒杀预约展示
     * @return
     */
    R getSeckill();

    /**
     * 秒杀活动查询
     * @param seckillTimeVo
     * @return
     */
   R getSeckillActivityInfo(SekillTimeVo seckillTimeVo);
}
