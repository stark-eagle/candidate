package com.example.demo.utils;

/**
 * @Author Administrator
 * @Date 2020/11/9
 */
public enum StatusEnum {

    /**
     * 请求成功
     */
    SUCCESS(200, "OK"),
    /**
     * 错误请求/权限不足
     */
    BAD_REQUEST(400, "Bad Request"),
    /**
     * 未找到资源
     */
    NOT_FOUND(404, "Not Found"),
    /**
     * 内部错误
     */
    INTERNAL_SERVER_ERROR(500, "Unknown Internal Error"),
    /**
     * 参数错误
     */
    NOT_VALID_PARAM(40005, "Not valid Params"),
    /**
     * 不支持造作
     */
    NOT_SUPPORTED_OPERATION(40006, "Operation not supported"),
    /**
     * 未登录
     */
    NOT_LOGIN(50000, "Not Login");




    private int code;
    private String standardMessage;

    StatusEnum(int code, String standardMessage) {
        this.code = code;
        this.standardMessage = standardMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStandardMessage() {
        return standardMessage;
    }

    public void setStandardMessage(String standardMessage) {
        this.standardMessage = standardMessage;
    }
}
