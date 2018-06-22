package com.qianlq.attendance.common;

import com.qianlq.attendance.common.constant.Result;

/**
 * @author qianliqing
 * @date 2018-03-20 下午3:54
 * mail: 1242202279@qq.com
 *
 * 统一的返回类型
 */

@SuppressWarnings("unchecked")
//json格式化忽略null值
//@JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
public final class BaseResult<T> {

    private int code;
    private String message;

    private T data = (T) new Object();

    public BaseResult() {
        this.data = (T) new Object();
    }

    public BaseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResult(Result result, T data) {
        this.code = result.getCode();
        this.message = result.getMsg();
        this.data = data;
    }

    public BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResult(Result result) {
        this();
        this.code = result.getCode();
        this.message = result.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResult{" + "code=" + code + ", message='" + message + ", data=" + data + '}';
    }
}
