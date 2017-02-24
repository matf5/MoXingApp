package com.mtf.moxingapp.util;

import com.mtf.moxingapp.model.Travel;

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
}
