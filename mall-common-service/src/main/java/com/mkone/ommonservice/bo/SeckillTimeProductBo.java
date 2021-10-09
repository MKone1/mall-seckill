package com.mkone.ommonservice.bo;

import com.mkone.ommonservice.entity.PmsProduct;
import com.mkone.ommonservice.entity.PmsSeckill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 业务对象
 * 秒杀场次+商品信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeckillTimeProductBo implements Serializable{
    public String name;//
    public String pic;//
    public Long pid;
    public String productSn;//货号
    public Date seckillTime;//秒杀开始时间
    public Integer seckillNum;//秒杀数量
    public BigDecimal seckillPrice;//秒杀价格
    public Date seckillEndTime;//秒杀结束时间
    public  Long  wareId;//仓库id
    public  Integer  stockLocked;//锁定库存

}
