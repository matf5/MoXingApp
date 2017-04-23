package com.mtf.moxingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.mtf.moxingapp.R;
import com.mtf.moxingapp.callback.JsonCallback;
import com.mtf.moxingapp.model.ResponseObj;
import com.mtf.moxingapp.util.MoXingUrl;
import com.mtf.moxingapp.util.SharePreferenceUtil;
import com.mtf.moxingapp.util.Util;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/3/5.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private android.support.v7.widget.Toolbar program_toolbar;
    private ImageView img_back;
    private EditText et_phonenum;
    private EditText et_password;
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    private void init() {
        initView();
    }

    private void initView() {
        program_toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.program_toolbar);
        img_back = (ImageView) findViewById(R.id.img_back);
        et_phonenum = (EditText) findViewById(R.id.et_phonenum);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
      /*  if (!Util.isMobileNO(et_phonenum.getText().toString())){
            Toast.makeText(LoginActivity.this,"请输入正确的手机号",Toast.LENGTH_SHORT);

        }
        if(et_password.getText().toString().length()<6){
            Toast.makeText(LoginActivity.this,"密码不能小于6位",Toast.LENGTH_SHORT);
        }
        else{
            login(et_phonenum.getText().toString(),et_password.getText().toString());

        }*/
    }
   /* private void login(final String phone_num, final String password) {
        OkGo.post(MoXingUrl.login).params("phoneNum", phone_num).params("password", password).execute(new JsonCallback<ResponseObj>(ResponseObj.class) {
            @Override
            public void onSuccess(ResponseObj responseObj, Call call, Response response) {
                if (responseObj.getCode() == 1) {
                    Log.e("login", responseObj.getData().toString());
                    SharePreferenceUtil.StoreUser(LoginActivity.this, phone_num, password, responseObj.getData().toString());
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);

                } else {
                    //Log.e("login", responseObj.getData().toString());
                }

            }


        });

    }*/
}
