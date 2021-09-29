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
    public  Long  sku_id;//sku_id
    public  Long  ware_id;//仓库id
    public  Integer  stock;//库存数
    public  String  sku_name;//sku_name
    public  Integer  stock_locked;//锁定库存
}
