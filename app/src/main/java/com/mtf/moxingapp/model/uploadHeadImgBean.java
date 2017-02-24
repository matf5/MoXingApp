package com.mtf.moxingapp.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/6.
 */
public class uploadHeadImgBean {

    /**
     * code : 1
     * msg : 上传头像成功
     * data : http://moxing1-1251789093.file.myqcloud.com/headImg201701061410242950258740.jpg
     */

    private int code;
    private String msg;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
