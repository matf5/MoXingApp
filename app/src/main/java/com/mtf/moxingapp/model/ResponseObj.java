package com.mtf.moxingapp.model;

/**
 * Created by Administrator on 2017/1/6.
 */
public class ResponseObj {
    public final static int OK = 1, FAILED = 0, EMPTY = -1;
    public final static String OK_STR = "成功", FAILED_STR = "失败", EMPTY_STR = "数据为空";

    private int code; // 状态码,0成功;1空数据;-1请求失败
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}