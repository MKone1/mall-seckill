package com.mkone.ommonservice.entity ;  

import com.baomidou.mybatisplus.annotation.TableId ;  
import lombok.AllArgsConstructor ;  
import lombok.Data ;  
import lombok.NoArgsConstructor ;

import java.io.Serializable;
import java.math.BigDecimal ;
import java.util.Date ;  

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OmsOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    public Long id ;  //订单id
    public Long member_id ;  //用户id
    public Long coupon_id ;  //优惠卷ID
    public String order_sn ;  //订单编号
    public Date create_time ;  //提交时间
    public String member_username ;  //用户帐号
    public BigDecimal total_amount ;  //订单总金额
    public BigDecimal pay_amount ;  //应付金额（实际支付金额）
    public BigDecimal freight_amount ;  //运费金额
    public BigDecimal promotion_amount ;  //促销优化金额（促销价、满减、阶梯价）
    public BigDecimal integration_amount ;  //积分抵扣金额
    public BigDecimal coupon_amount ;  //优惠券抵扣金额
    public BigDecimal discount_amount ;  //管理员后台调整订单使用的折扣金额
    public Integer pay_type ;  //支付方式：0->未支付；1->支付宝；2->微信
    public Integer source_type ;  //订单来源：0->PC订单；1->app订单
    public Integer status ;  //订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
    public Integer order_type ;  //订单类型：0->正常订单；1->秒杀订单
    public String delivery_company ;  //物流公司(配送方式)
    public String delivery_sn ;  //物流单号
    public Integer auto_confirm_day ;  //自动确认时间（天）
    public Integer integration ;  //可以获得的积分
    public Integer growth ;  //可以活动的成长值
    public String promotion_info ;  //活动信息
    public Integer bill_type ;  //发票类型：0->不开发票；1->电子发票；2->纸质发票
    public String bill_header ;  //发票抬头
    public String bill_content ;  //发票内容
    public String bill_receiver_phone ;  //收票人电话
    public String bill_receiver_email ;  //收票人邮箱
    public String receiver_name ;  //收货人姓名
    public String receiver_phone ;  //收货人电话
    public String receiver_post_code ;  //收货人邮编
    public String receiver_province ;  //省份/直辖市
    public String receiver_city ;  //城市
    public String receiver_region ;  //区
    public String receiver_detail_address ;  //详细地址
    public String note ;  //订单备注
    public Integer confirm_status ;  //确认收货状态：0->未确认；1->已确认
    public Integer delete_status ;  //删除状态：0->未删除；1->已删除
    public Integer use_integration ;  //下单时使用的积分
    public Date payment_time ;  //支付时间
    public Date delivery_time ;  //发货时间
    public Date receive_time ;  //确认收货时间
    public Date comment_time ;  //评价时间
    public Date modify_time ;  //修改时间

}
