package com.zzx.commons.exceptions;

public class CommonException extends RuntimeException {
    /**
     * �쳣code
     */
    private int code;
    /**
     * �쳣��ϸ��Ϣ
     */
    private String message;
    /**
     * Դ�쳣
     */
    private Throwable throwable;

    public CommonException() {
    }

    public CommonException(String message) {
        this.code = 500;
        this.message = message;
    }

    public CommonException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonException(Throwable throwable) {
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
