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
    @TableId
    public Integer id;//
    public Integer seckillProId;//
    public Date seckillTime;//
    public Integer seckillNum;//
    public BigDecimal seckillPrice;//
}
