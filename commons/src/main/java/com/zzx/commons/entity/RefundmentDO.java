package com.zzx.commons.entity;

import org.springframework.lang.NonNull;

import java.util.Date;

/**
 * �˿�������
 */
public class RefundmentDO extends BaseDO {
    /**
     * id
     */
    private Integer id;

    /**
     * �˿�id
     */
    @NonNull
    private String refundmentId;

    /**
     * ����������id
     */
    @NonNull
    private String orderId;

    /**
     * ���
     */
    @NonNull
    private String money;

    /**
     * ��ע
     */
    @NonNull
    private String mark;

    /**
     * ����ʱ��
     */
    private Date creadeTime;

    /**
     * ����ʱ��
     */
    private Date updateTime;

    @Override
    public String toString() {
        return "RefundmentDO{" +
                "id=" + id +
                ", refundmentId='" + refundmentId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", money='" + money + '\'' +
                ", mark='" + mark + '\'' +
                ", creadeTime=" + creadeTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRefundmentId() {
        return refundmentId;
    }

    public void setRefundmentId(String refundmentId) {
        this.refundmentId = refundmentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Date getCreadeTime() {
        return creadeTime;
    }

    public void setCreadeTime(Date creadeTime) {
        this.creadeTime = creadeTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}