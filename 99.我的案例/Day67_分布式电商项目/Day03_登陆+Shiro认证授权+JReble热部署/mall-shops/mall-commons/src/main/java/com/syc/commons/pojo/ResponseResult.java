package com.syc.commons.pojo;

import java.io.Serializable;

/**
 * 与前端交互的响应结果
 */
public class ResponseResult<T> implements Serializable{

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 响应信息
     */
    private String msg;

    /**
     *时间戳
     */
    private long timeStamp=System.currentTimeMillis();

    /**
     * 结果对象
     */
    private T result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
