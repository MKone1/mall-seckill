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
public class UmsMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    public Long id;//
    public Date birthday;//生日
    public String city;//所做城市
    public Date createTime;//注册时间
    public Integer gender;//性别：0->未知；1->男；2->女
    public Integer growth;//成长值
    public Integer historyIntegration;//历史积分数量
    public String icon;//头像
    public Integer integration;//积分
    public String job;//职业
    public Integer luckeyCount;//剩余抽奖次数
    public Long memberLevelId;//
    public String nickname;//昵称
    public String password;//密码
    public String personalizedSignature;//个性签名
    public String phone;//手机号码
    public Integer sourceType;//用户来源
    public Integer status;//帐号启用状态:0->禁用；1->启用
    public String username;//用户名

}
