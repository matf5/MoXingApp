package com.mtf.moxingapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mtf.moxingapp.R;

/**
 * Created by Administrator on 2016/12/26.
 */
public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_register;
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        init();
    }

    private void init() {
        initView();
    }

    private void initView() {
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_register=(Button)findViewById(R.id.btn_register);
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:

                break;
            case R.id.btn_register:
                break;
        }
    }
}
