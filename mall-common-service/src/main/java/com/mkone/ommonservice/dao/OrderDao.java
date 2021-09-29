package com.mkone.ommonservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mkone.ommonservice.entity.OmsOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao extends BaseMapper<OmsOrder> {
}
