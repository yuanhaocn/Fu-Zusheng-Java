package com.syc.commons.utils;

import com.syc.commons.pojo.ResponseResult;

/**
 * 响应信息工具类
 * @param <T>
 */
public class ResultUtil<T> {

    private ResponseResult<T> result;

    public ResultUtil(){
        result=new ResponseResult<>();
        result.setSuccess(true);
        result.setMsg("success");
    }

    public ResponseResult<T> setData(T t){
        this.result.setResult(t);
        return this.result;
    }

    public ResponseResult<T> setErrorMsg(String msg){
        this.result.setSuccess(false);
        this.result.setMsg(msg);
        return this.result;
    }
}
