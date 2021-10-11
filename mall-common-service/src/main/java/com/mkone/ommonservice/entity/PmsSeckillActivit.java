package com.mkone.ommonservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PmsSeckillActivit implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private Long seckillActivitId;
    private Date seckillTime;
    private Date seckillEndTime;

    public PmsSeckillActivit(Long seckillActivitId, Date seckillTime, Date seckillEndTime) {
        this.seckillActivitId = seckillActivitId;
        this.seckillEndTime = seckillEndTime;
        this.seckillTime = seckillTime;
    }
}
