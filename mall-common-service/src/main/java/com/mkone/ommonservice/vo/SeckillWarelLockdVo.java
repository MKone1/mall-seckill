package com.mkone.ommonservice.vo;

import com.mkone.ommonservice.entity.PmsProduct;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class SeckillWarelLockdVo implements Serializable {
    private static final long serialVersionUID = 1L;
    public String orderSn;
    public List<PmsProduct> pmsProductList;
}
