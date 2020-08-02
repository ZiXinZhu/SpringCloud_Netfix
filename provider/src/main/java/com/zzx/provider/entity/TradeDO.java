package com.zzx.provider.entity;

import com.zzx.provider.exceptions.CommonException;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * �ص����������
 */

/**
 * @author Husky
 */
public class TradeDO extends BaseDO implements Serializable {
    /**
     * id
     */
    private int id;
    /**
     * ��������
     */
    @NonNull
    private String tradeDate;
    /**
     * ����ʱ��
     */
    @NonNull
    private String tradeTime;
    /**
     * ���
     */
    @NonNull
    private String money;
    /**
     * ��������
     */
    private String tradeType;
    /**
     * ��ע
     */
    private String remark;
    /**
     * �����֤
     */
    @NonNull
    private String identity;
    /**
     * ��������
     */
    @NonNull
    private String bank;
    /**
     * �Ƿ��ϱ�
     */
    @NonNull
    private String report;
    /**
     * �����˻�
     */
    private String bankAccount;
    /**
     * ���ʱ��
     */
    private String insertime;


    @Override
    public void available() {
        if (this.getId() == 0) {
            throw new CommonException(502, "ID����Ϊ�գ�");
        }
        Assert.notNull(this.getBank(), "������д����Ϊ��");
        Assert.notNull(this.getRemark(), "��ע����Ϊ��");
    }

    @Override
    public String toString() {
        return "TradeDO{" +
                "id=" + id +
                ", tradeDate='" + tradeDate + '\'' +
                ", tradeTime='" + tradeTime + '\'' +
                ", money='" + money + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", remark='" + remark + '\'' +
                ", identity='" + identity + '\'' +
                ", bank='" + bank + '\'' +
                ", report='" + report + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", insertime='" + insertime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getInsertime() {
        return insertime;
    }

    public void setInsertime(String insertime) {
        this.insertime = insertime;
    }
}
