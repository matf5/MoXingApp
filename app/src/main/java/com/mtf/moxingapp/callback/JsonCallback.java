package com.mtf.moxingapp.callback;

import com.google.gson.Gson;
import com.lzy.okgo.callback.AbsCallback;


import org.json.JSONObject;

import java.lang.reflect.Type;

import okhttp3.Response;

/**
 * Created by Administrator on 2017/1/6.
 */
public abstract class JsonCallback<T> extends AbsCallback<T> {
    private Class<T> clazz;
    private Type type;

    public JsonCallback(Class<T> clazz) {
        this.clazz = clazz;
    }

    public JsonCallback(Type type) {
        this.type = type;
    }



    @Override
    public T convertSuccess(Response response) throws Exception {
        String responseData = response.body().string();
        JSONObject jsonObject = new JSONObject(responseData);
        String code = jsonObject.optString("code", "");
        if (clazz == String.class) {
           // Log.e("clazz", "0");
            return (T) responseData;
        }
        if (clazz != null) {
            //Log.e("clazz", "1");

            //ResponseJson responseJson = new Gson().fromJson(responseData,ResponseJson.class);
            return new Gson().fromJson(responseData, clazz);
        }
        if (type != null) {
            //Log.e("clazz", "2");
            return new Gson().fromJson(responseData, type);
        }
        return null;
    }


}
