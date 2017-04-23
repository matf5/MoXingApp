package com.mtf.moxingapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mtf.moxingapp.R;
import com.mtf.moxingapp.util.MoXingData;
import com.mtf.moxingapp.util.SharePreferenceUtil;

/**
 * Created by Administrator on 2017/3/4.
 */
public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        goNext();
     }

    private void goNext() {
        SharePreferenceUtil.init(SplashActivity.this);
        Intent intent;
        if(!SharePreferenceUtil.getLoginOrNot())
            intent = new Intent(SplashActivity.this,StartActivity.class);
        else {
            intent = new Intent(SplashActivity.this, MainActivity.class);
            MoXingData.user_id = SharePreferenceUtil.get(SharePreferenceUtil.USER_ID,"0");
        }
        startActivity(intent);
    }

}
