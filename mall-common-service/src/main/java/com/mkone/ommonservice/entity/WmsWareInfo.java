package com.mkone.ommonservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WmsWareInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    public  Long  id;//id
    public  String  name;//仓库名
    public  String  address;//仓库地址
    public  String  areacode;//区域编码
}
