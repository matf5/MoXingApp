package com.mtf.moxingapp.util;

import android.text.TextUtils;

import com.mtf.moxingapp.model.Travel;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/22.
 */
public class Util {
    public static String dateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        return format.format(date);
    }
    public static Boolean isTravelFilled(Travel travel){
        if(travel.getBeginPosProv()!=null&&travel.getDestPosCity()!=null&&travel.getDescription()!=null
                &&travel.getBeginDate()!=null&&travel.getEndDate()!=null&&travel.getBeginPosCity()!=null
                &&travel.getDestPosProv()!=null&&travel.getImgUrl()!=null&&travel.getTitle()!=null&&travel.getUserId()!=null
                &&travel.getDescription()!=null&&travel.getLongitude()!=null&&travel.getLatitude()!=null)
            return true;
        else
            return false;


    }
    public static Boolean isMobileNO(String mobiles) {
		/*
		移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		联通：130、131、132、152、155、156、185、186
		电信：133、153、180、189、（1349卫通）
		总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
		*/
        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }
    public static  double getDistancce(double XLongtitude,double XLatitude,double YLongtitude,double YLatitude){
        NumberFormat nf=new DecimalFormat( "0.0 ");
        double R=6371;
        double d =Double.parseDouble(nf.format(Math.acos(Math.sin(XLatitude)*Math.sin(YLatitude)+Math.cos(XLatitude)*Math.cos(YLatitude)*Math.cos(XLongtitude-YLongtitude))*R));
        return d;
    }
}
