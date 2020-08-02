package com.zzx.provider.entity;

import com.zzx.provider.enums.ContainEnum;

import java.io.Serializable;

/**
 * ����entity
 */
public class BaseDO implements Serializable{
    /**
     * ����ö������
     */
    private ContainEnum containEnum;

    /**
     * ����У��
     */
    public void available() {

    }

    @Override
    public BaseDO clone() throws CloneNotSupportedException {
        return (BaseDO) super.clone();
    }

    public ContainEnum getContainEnum() {
        return containEnum;
    }

    public void setContainEnum(ContainEnum containEnum) {
        this.containEnum = containEnum;
    }
}
