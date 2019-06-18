package com.test.mycat.common;

import java.io.Serializable;

/**
 * HTTP接口返回对象
 */
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code; // 状态码
    private String message; // 返回信息
    private T content; // 返回具体对象信息

    private static ResponseResult success = new ResponseResult(200);
    private static ResponseResult error = new ResponseResult(500, "失败");

    private String tid;

    public ResponseResult() {
    }

    public ResponseResult(int code) {
        this.code = code;
    }

    public ResponseResult(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public ResponseResult(int code, String message, T content) {
        this.message = message;
        this.code = code;
        this.content = content;
    }

    public ResponseResult(int code, String message, T content, String tid) {
        this.message = message;
        this.code = code;
        this.content = content;
        this.tid = tid;
    }

    public static ResponseResult success() {
        return success;
    }

    public static ResponseResult success(Object content) {
        return new ResponseResult(200, "成功", content);
    }

    public static ResponseResult error() {
        return error;
    }

    public static ResponseResult error(Object content) {
        return new ResponseResult(500, "失败", content);
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", content=" + content +
                ", tid='" + tid + '\'' +
                '}';
    }
}
