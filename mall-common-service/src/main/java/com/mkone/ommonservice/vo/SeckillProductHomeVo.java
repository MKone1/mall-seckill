package com.mkone.ommonservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 首页中秒杀预告Vo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeckillProductHomeVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String productName;//商品名
    private BigDecimal seckillPrice;// 秒杀价格
    private String productPic;//商品图片
    private Integer seckillNum;//秒杀商品数量
}
