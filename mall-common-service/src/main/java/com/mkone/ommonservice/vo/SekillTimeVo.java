package com.mkone.ommonservice.vo;

import lombok.Data;

import java.util.Date;

/**
 * time 必传
 * ActivityId非必传
 */
@Data
public class SekillTimeVo {
    private Long times;//当前时间毫秒数
    private Integer ActivityId;//活动ID
}
