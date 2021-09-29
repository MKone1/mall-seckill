package com.mkone.ommonservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WmsWareSku implements Serializable {
    public  Long  id;//id
    public  Long  skuId;//sku_id
    public  Long  wareId;//仓库id
    public  Integer  stock;//库存数
    public  String  skuName;//sku_name
    public  Integer  stockLocked;//锁定库存
}
