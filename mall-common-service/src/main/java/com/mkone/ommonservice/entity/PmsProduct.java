package com.mkone.ommonservice.entity;//

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PmsProduct implements Serializable {
    @TableId
    public Long id;//
    public Long brandId;//
    public Long productCategoryId;//
    public Long feightTemplateId;//
    public Long productAttributeCategoryId;//
    public String name;//
    public String pic;//
    public String productSn;//货号
    public Integer deleteStatus;//删除状态：0->未删除；1->已删除
    public Integer publishStatus;//上架状态：0->下架；1->上架
    public Integer newStatus;//新品状态:0->不是新品；1->新品
    public Integer recommandStatus;//推荐状态；0->不推荐；1->推荐
    public Integer verifyStatus;//审核状态：0->未审核；1->审核通过
    public Integer sort;//排序
    public Integer sale;//销量
    public BigDecimal price;//
    public BigDecimal promotionPrice;//促销价格
    public Integer giftGrowth;//赠送的成长值
    public Integer giftPoint;//赠送的积分
    public Integer usePointLimit;//限制使用的积分数
    public String subTitle;//副标题
    public String description;//商品描述
    public BigDecimal originalPrice;//市场价
    public Integer stock;//库存
    public Integer lowStock;//库存预警值
    public String unit;//单位
    public BigDecimal weight;//商品重量，默认为克
    public Integer previewStatus;//是否为预告商品：0->不是；1->是
    public String serviceIds;//以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
    public String keywords;//
    public String note;//
    public String albumPics;//画册图片，连产品图片限制为5张，以逗号分割
    public String detailTitle;//
    public String detailDesc;//
    public String detailHtml;//产品详情网页内容
    public String detailMobileHtml;//移动端网页详情
    public Date promotionStartTime;//促销开始时间
    public Date promotionEndTime;//促销结束时间
    public Integer promotionPerLimit;//活动限购数量
    public Integer promotionType;//促销类型：0->没有促销使用原价;//1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
    public String brandName;//品牌名称
    public String productCategoryName;//商品分类名称

}
