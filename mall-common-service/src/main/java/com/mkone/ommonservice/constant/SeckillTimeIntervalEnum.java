package com.mkone.ommonservice.constant;

import java.util.ArrayList;
import java.util.List;

//秒杀时间段
public enum SeckillTimeIntervalEnum {
    FIRSTTIME(0, 2, 4),
    SECONDTIME(2, 4, 6),
    THIRDTIME(4, 6, 8),
    FROUTHTIME(6, 8, 10),
    FIFTHTIME(8, 10, 12),
    SIXTHTIME(10, 12, 14),
    SEVENTHTIME(12, 14, 16),
    EIGHTHTIME(14, 16, 18),
    NINTHTIME(16, 18, 20),
    TENTHTIME(18, 20, 22),
    ELEVENTHTIME(20, 22, 24),
    TELFTHTIME(22, 0, 2);
    private Integer timePoint;
    private Integer startTime;
    private Integer endTime;

    SeckillTimeIntervalEnum(Integer timePoint, Integer startTime, Integer endTime) {
        this.endTime = endTime;
        this.startTime = startTime;
        this.timePoint = timePoint;
    }

    public Integer getTimePoint() {
        return timePoint;
    }

    public String getTime(Integer timePoint) {
        return startTime + "_" + endTime;
    }
    public String getTime(){
        return startTime+"_"+endTime;
    }

}

