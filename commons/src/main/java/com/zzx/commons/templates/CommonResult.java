package com.zzx.commons.templates;

public class CommonResult<T> extends BaseResult {
    /**
     * 泛型参数
     */
    private T result;

    @Override
    public String toString() {
        return "CommonResult{" +
                "result=" + result +
                '}';
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
