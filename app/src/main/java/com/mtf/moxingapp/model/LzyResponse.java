package com.mtf.moxingapp.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/6.
 */
public class LzyResponse<T> implements Serializable {

    private static final long serialVersionUID = 5213230387175987834L;

    public int code;
    public String msg;
    public T data;
}