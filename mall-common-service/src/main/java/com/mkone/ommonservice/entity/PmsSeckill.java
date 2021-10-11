package com.mkone.ommonservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PmsSeckill implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    public Integer id;//id
    public Integer seckillProId;//秒杀商品ID
    public Date seckillTime;//秒杀开始时间
    public Integer seckillNum;//秒杀数量
    public BigDecimal seckillPrice;//秒杀价格
    public Date seckillEndTime;//秒杀结束时间
    public Long seckillActivitId;//秒杀活动ID
}
