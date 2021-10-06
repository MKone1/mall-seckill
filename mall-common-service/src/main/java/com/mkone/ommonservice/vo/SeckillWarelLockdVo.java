package com.mkone.ommonservice.vo;

import com.mkone.ommonservice.entity.PmsProduct;
import lombok.Data;

import java.util.List;
@Data
public class SeckillWarelLockdVo {
    public String orderSn;
    public List<PmsProduct> pmsProductList;
}
