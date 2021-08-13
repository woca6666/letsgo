package com.myzone.demoshardingjdbc.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubOrderEntityVo implements Serializable {
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
     *  缴费公司姓名
     */
    private String companyName;

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
}
