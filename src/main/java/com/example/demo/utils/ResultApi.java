package com.example.demo.utils;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.HashMap;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/11/9
 */
public class ResultApi extends  HashMap<String,Object>{

    private static final long serialVersionUID = 1L;

    public ResultApi() {
        put("code", StatusEnum.SUCCESS.getCode());
        put("msg", "success");
        put("data", new HashMap<>());
    }

    /**
     * 功能：判断请求是否成功 详细：
     *
     * @return 成功返回true
     */
    @JsonIgnore
    public boolean isSuccess() {
        return (int) get("code") == StatusEnum.SUCCESS.getCode();
    }

    public static ResultApi failure() {
        return failure(StatusEnum.INTERNAL_SERVER_ERROR.getCode(), "由于系统维护，请稍后再试");
    }

    public static ResultApi failure(String msg) {
        return failure(StatusEnum.BAD_REQUEST.getCode(), msg);
    }

    public static ResultApi failure(StatusEnum status) {
        return failure(status.getCode(), status.getStandardMessage());
    }

    public static ResultApi failure(int code, String msg) {
        ResultApi result = new ResultApi();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data", null);
        return result;
    }

    public static ResultApi success(String msg) {
        ResultApi result = new ResultApi();
        result.put("msg", msg);
        return result;
    }

    public static ResultApi success() {
        return new ResultApi();
    }

    @Override
    public ResultApi put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 设置data数据
     */
    public <T> ResultApi setData(T data) {
        this.put("data", data);
        return this;
    }

    /**
     * 获取data数据
     */
    public <T> T getData(Class<T> clazz) {
        return (T) this.get("data");
    }

    /**
     * data加数据
     */
    public ResultApi putData(String key, Object value) {
        ((HashMap) super.get("data")).put(key, value);
        return this;
    }


    /**
     * data加list
     */
    public <T> ResultApi addData(List<T> list) {
        this.putData("list", list);
        return this;
    }

    /**
     * data加单个对象数据
     */
    public <T> ResultApi addData(T info) {
        this.putData("info", info);
        return this;
    }
}
