package com.mtf.moxingapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.mtf.moxingapp.model.UserInfo;

/**
 * Created by Administrator on 2017/3/4.
 */
public class SharePreferenceUtil {
    public final static String USER_ID ="user_id";
    public final static String LOGIN_OR_NOT = "login_or_not";
    public final static  String PHONE_NUM = "phone_num";
    public final static String STORE_NAME="store_name";
    public final static String NICK_NAME ="nick_name";
    public final static String PASSWORD="password";
    private static Context context;
    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;

    public static void init(Context context){

            SharePreferenceUtil.context = context;
            sp = context.getSharedPreferences(STORE_NAME, Context.MODE_PRIVATE);
            editor = sp.edit();
            //getDatas();

    }
    public static void StoreUser(Context context,String phonenum,String password,String user_id){
        editor.putString(PHONE_NUM, phonenum);
        editor.putString(PASSWORD,password);
        editor.putString(USER_ID,user_id);
        editor.putBoolean(LOGIN_OR_NOT, true);
        editor.commit();
    }

    public static void StoreUserInfo(Context context,UserInfo userInfo){
        editor.putString(PHONE_NUM, userInfo.getPhoneNum());
        editor.putBoolean(LOGIN_OR_NOT, true);
        editor.putString(USER_ID, userInfo.getId() + "");
        editor.commit();
    }

    public static void set(String key,String value){
        editor.putString(key,value);
        editor.commit();
    }
    public static void set(String key,boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }
    public static String get(String key,String defvalue){
        return sp.getString(key,defvalue);
    }
    public static boolean get(String key,boolean defvalue) {
        return sp.getBoolean(key, defvalue);
    }
    public static void setLoginOrNot(boolean loginOrNot){
        set(LOGIN_OR_NOT,loginOrNot);
    }
    public static void setNickname(String name){
        set(NICK_NAME,name);
    }
    public static boolean getLoginOrNot(){
        return get(LOGIN_OR_NOT,false);
    }

}
