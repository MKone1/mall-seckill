package com.mkone.ommonservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mkone.ommonservice.entity.WmsWareSku;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface WmsWareSkuDao extends BaseMapper<WmsWareSku> {
}
