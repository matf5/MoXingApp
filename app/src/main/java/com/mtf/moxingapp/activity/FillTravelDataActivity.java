package com.mtf.moxingapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mtf.moxingapp.R;

/**
 * Created by Administrator on 2017/2/19.
 */
public class FillTravelDataActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_save;
    private EditText et_fill_data;
    public final static String TITLE_OR_DESCRI="TITLE_OR_DESCRI";
    public int type =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_travel_data);
        init();
        type=getIntent().getIntExtra(TITLE_OR_DESCRI, 0);

    }

    private void init() {
        btn_save = (Button)findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);
        et_fill_data=(EditText)findViewById(R.id.et_fill_data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save:
                if(!TextUtils.isEmpty(et_fill_data.getText().toString())) {
                    switch (type) {
                        case 0:
                            ReleaseTravelActivity.getTravel().setTitle(et_fill_data.getText().toString());
                            break;
                        case 1:
                            ReleaseTravelActivity.getTravel().setDescription(et_fill_data.getText().toString());
                            break;

                    }
                    setResult(RESULT_OK);
                    finish();
                    break;
                }
        }
    }
}
