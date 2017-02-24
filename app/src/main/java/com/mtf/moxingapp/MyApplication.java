package com.mtf.moxingapp;

import android.app.Application;
import android.app.Service;
import android.os.Vibrator;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.location.service.LocationService;
import com.baidu.mapapi.SDKInitializer;
import com.lzy.okgo.OkGo;

import java.util.List;
import java.util.logging.Level;

/**
 * Created by Administrator on 2016/12/6.
 */
public class MyApplication extends Application {
    public LocationService locationService;
    public Vibrator mVibrator;
    @Override
    public void onCreate() {
        super.onCreate();
       // FreelineCore.init(this);
        OkGo.init(this);
        OkGo.getInstance()

                // 打开该调试开关,打印级别INFO,并不是异常,是为了显眼,不需要就不要加入该行
                // 最后的true表示是否打印okgo的内部异常，一般打开方便调试错误
                .debug("OkGo", Level.INFO, true);
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());

    }

}
