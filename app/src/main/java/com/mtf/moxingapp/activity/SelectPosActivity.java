package com.mtf.moxingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mtf.moxingapp.R;
import com.mtf.moxingapp.adapter.CityAdapter;
import com.mtf.moxingapp.adapter.ProvinceAdapter;
import com.mtf.moxingapp.model.City;
import com.mtf.moxingapp.model.Province;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public class SelectPosActivity extends AppCompatActivity implements View.OnClickListener{
    private Spinner sp_prov;
    private Spinner sp_city;
    private List<Province> list_prov;
    private List<City> list_all_city;
    private List<City> list_city = new ArrayList<City>();
    private CityAdapter cityAdapter;
    private ProvinceAdapter provinceAdapter;
    public final static String TYPE = "TYPE";
    private Button btn_save;
    private int type =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_pos);
        Intent intent = getIntent();
        type=intent.getIntExtra(TYPE,0);
        init();
        initData();

    }

    private void initData() {

        initProvinces();
        initAllCity();

    }

    private void init() {
        sp_prov = (Spinner) findViewById(R.id.sp_prov);
        sp_city = (Spinner) findViewById(R.id.sp_city);
        btn_save = (Button)findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);

    }
    private void initProvinces() {
        list_prov = new Gson().fromJson(getStrFromAssets("json_prov.json"), new TypeToken<List<Province>>() {
        }.getType());
        provinceAdapter = new ProvinceAdapter(this, list_prov);
        cityAdapter = new CityAdapter(this, list_city);
        sp_prov.setAdapter(provinceAdapter);
        sp_city.setAdapter(cityAdapter);
        sp_prov.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (type){
                    case 0:
                        ReleaseTravelActivity.getTravel().setBeginPosProv(list_prov.get(position).getName());
                        break;
                    case 1:
                        ReleaseTravelActivity.getTravel().setDestPosProv(list_prov.get(position).getName());
                        break;
                }

                initCity(list_prov.get(position).getProID());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (type){
                    case 0:

                        ReleaseTravelActivity.getTravel().setBeginPosCity(list_city.get(position).getName());
                        break;
                    case 1:
                        ReleaseTravelActivity.getTravel().setDestPosCity(list_city.get(position).getName());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Log.e("listprov",list_prov.get(0).getName());
    }

    private void initAllCity() {
        list_all_city = new Gson().fromJson(getStrFromAssets("json_city.json"), new TypeToken<List<City>>() {
        }.getType());
        Log.e("list_all_city", list_all_city.size() + "");

    }

    private void initCity(int proId) {
        list_city.clear();
        for (int i = 0; i < list_all_city.size(); i++) {
            if (list_all_city.get(i).getProID() == proId) {
                list_city.add(list_all_city.get(i));
            }

        }
        cityAdapter.notifyDataSetChanged();

    }

    private String getStrFromAssets(String name) {
        String strData = null;
        try {
            InputStream inputStream = getAssets().open(name);
            int size = inputStream.available();
            byte buf[] = new byte[size];
            inputStream.read(buf);
            strData = new String(buf);
            strData = strData.trim();

        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        System.out.println("strData = " + strData);
        return strData;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_save:
                 setResult(RESULT_OK);
                 finish();
                 break;
        }
    }
}
