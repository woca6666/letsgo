package com.myzone.demoshardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 生活缴费 子订单表
 */
@Data
@TableName("sub_order")
@ToString
public class SubOrderEntity implements Serializable
{
    public static final String PAY_TYPE_WX = "WECHAT";//微信
    public static final String PAY_TYPE_ZFB = "ALIPAY";//支付宝

    private static final long serialVersionUID = 5137088369106083382L;

    @TableId
    private Long id;

    /**
     *  子订单号
     */
    private String subOrderId;

    /**
     *  关联的总订单表
     */
    private String totalOrderId;

    /**
     *  用户Id
     */
    private String userId;

    /**
     *  订单类型，水、电
     */
    private String orderType;

    /**
     *  缴费公司代码
     */
    private String companyCode;

    /**
     * 金额
     */
    private String subFee;

    /**
     *  订单状态
     */
    private String orderStatus;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 完成时间
     */
    private String finishTime;

    /**
     * 通知订单id
     */
    private String notifyOrderId;

    /**
     * 通知订单状态
     */
    private String notifyOrderStatus;

    /**
     * 通知失败原因
     */
    private String notifyFailReason;

    /**
     * 用户号
     */
    private String cardNo;
    /**
     * 支付方式
     */
    private String payType;
    /**
     *  山亭特例-水司编码
     */
    private String acctOrgNo;
}
