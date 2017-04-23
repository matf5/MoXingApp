package com.mtf.moxingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.mtf.moxingapp.R;
import com.mtf.moxingapp.callback.JsonCallback;
import com.mtf.moxingapp.event.MainEvent;
import com.mtf.moxingapp.model.ResponseObj;
import com.mtf.moxingapp.util.MoXingUrl;
import com.mtf.moxingapp.util.SharePreferenceUtil;
import com.mtf.moxingapp.util.Util;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import okhttp3.Call;
import okhttp3.Response;

import static cn.smssdk.SMSSDK.getVerificationCode;
import static cn.smssdk.SMSSDK.submitVerificationCode;

/**
 * Created by Administrator on 2017/2/25.
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private android.support.v7.widget.Toolbar program_toolbar;
    private ImageView img_back;
    private EditText et_phonenum;
    private EditText et_identity;
    private EditText et_password;
    private Button btn_identity;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
        init();

    }

    private void init() {
        bindView();
        initSDK();
    }

    private void bindView() {
        program_toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.program_toolbar);
        img_back = (ImageView) program_toolbar.findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
        et_phonenum = (EditText) findViewById(R.id.et_phonenum);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
        et_identity = (EditText) findViewById(R.id.et_identity);
        btn_identity = (Button) findViewById(R.id.btn_identity);
        btn_identity.setOnClickListener(this);
        et_password = (EditText) findViewById(R.id.et_password);
    }

    private void initSDK() {
        // 初始化短信SDK
        SMSSDK.initSDK(RegisterActivity.this, "1b99245736fde", "6854e12a4c07a52bc40bd5841a8514d6");
        SMSSDK.registerEventHandler(eh); //注册短信回调
    }

    EventHandler eh = new EventHandler() {
        @Override
        public void afterEvent(int event, int result, Object data) {

            if (result == SMSSDK.RESULT_COMPLETE) {
                //回调完成
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    EventBus.getDefault().post(
                            new MainEvent(1));
                    //验证码验证成功
                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    EventBus.getDefault().post(
                            new MainEvent(2));

                    //获取验证码成功
                } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                    EventBus.getDefault().post(
                            new MainEvent(3));
                    //返回支持发送验证码的国家列表
                }
            } else {
                EventBus.getDefault().post(
                        new MainEvent(4));
                //Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
                ((Throwable) data).printStackTrace();
                Log.e("regist", Log.getStackTraceString((Throwable) data));
            }
            //Looper.loop();
        }
    };

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MainEvent event) {
        if (event.getMsg() == 1) {
            Log.e("event", "1");
            Toast.makeText(RegisterActivity.this, "提交验证码成功", Toast.LENGTH_SHORT).show();
            //生成Token
            //发送注册请求
            registerUser(et_phonenum.getText().toString(), et_password.getText().toString());


        }
        if (event.getMsg() == 2) {
            Toast.makeText(RegisterActivity.this, "获取验证码成功", Toast.LENGTH_SHORT).show();
        }
        if (event.getMsg() == 4) {
            Toast.makeText(RegisterActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
        }

    }

    private void registerUser(final String phone_num, final String password) {
        OkGo.post(MoXingUrl.reg).params("phoneNum", phone_num).params("password", password).execute(new JsonCallback<ResponseObj>(ResponseObj.class) {
            @Override
            public void onSuccess(ResponseObj responseObj, Call call, Response response) {
                if (responseObj.getCode() == 1) {
                    // Log.e("img_file", responseObj.getData().toString());
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT);
                    login(phone_num, password);
                }

            }


        });

    }

    private void login(final String phone_num, final String password) {
        OkGo.post(MoXingUrl.login).params("phoneNum", phone_num).params("password", password).execute(new JsonCallback<ResponseObj>(ResponseObj.class) {
            @Override
            public void onSuccess(ResponseObj responseObj, Call call, Response response) {
                if (responseObj.getCode() == 1) {
                    Log.e("login", responseObj.getData().toString());
                    SharePreferenceUtil.StoreUser(RegisterActivity.this, phone_num, password, responseObj.getData().toString());
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);

                } else {
                    Log.e("login", responseObj.getData().toString());
                }

            }


        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                if (Util.isMobileNO(et_phonenum.getText().toString()) && (et_identity.getText().toString().length() == 4) && (et_password.getText().toString().length() >= 6)) {
                    submitVerificationCode("86", et_phonenum.getText().toString(), et_identity.getText().toString());
                } else if (!Util.isMobileNO(et_phonenum.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "手机号输入错误", Toast.LENGTH_SHORT);
                } else if (et_password.getText().toString().length() < 6) {
                    Toast.makeText(RegisterActivity.this, "密码不能小于6位", Toast.LENGTH_SHORT);
                } else

                {
                    Toast.makeText(RegisterActivity.this, "请输入4位验证码", Toast.LENGTH_SHORT);

                }

                break;
            case R.id.btn_identity:
                if (!Util.isMobileNO(et_phonenum.getText().toString()))
                    Toast.makeText(RegisterActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                else {
                    getVerificationCode("86", et_phonenum.getText().toString());
                }
                break;
        }
    }
}
