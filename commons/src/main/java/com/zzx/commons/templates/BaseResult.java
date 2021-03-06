package com.zzx.commons.templates;

public class BaseResult {
    /**
     * �Ƿ�ɹ�
     */
    private boolean success = false;
    /**
     * ���ش���
     */
    private int code;
    /**
     * ��������
     */
    private String describe;

    @Override
    public String toString() {
        return "BaseResult{" +
                "success=" + success +
                ", code=" + code +
                ", describe='" + describe + '\'' +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
