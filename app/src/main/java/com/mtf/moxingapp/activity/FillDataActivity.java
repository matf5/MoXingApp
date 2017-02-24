package com.mtf.moxingapp.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.mtf.moxingapp.R;
import com.mtf.moxingapp.adapter.CityAdapter;
import com.mtf.moxingapp.adapter.ProvinceAdapter;
import com.mtf.moxingapp.callback.JsonCallback;
import com.mtf.moxingapp.callback.StringCallback;
import com.mtf.moxingapp.model.City;
import com.mtf.moxingapp.model.Province;
import com.mtf.moxingapp.model.ResponseObj;
import com.mtf.moxingapp.model.UserInfo;
import com.mtf.moxingapp.util.CircularImageView;
import com.mtf.moxingapp.util.MoXingData;
import com.mtf.moxingapp.util.MoXingUrl;
import com.mtf.moxingapp.util.SelectHeadPicDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/1/2.
 */
public class FillDataActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup rg_sex;
    private RadioButton rgbtn_boy;
    private RadioButton rgbtn_girl;
    private Spinner sp_prov;
    private Spinner sp_city;
    private List<Province> list_prov;
    private List<City> list_all_city;
    private List<City> list_city = new ArrayList<City>();
    private CityAdapter cityAdapter;
    private ProvinceAdapter provinceAdapter;
    private UserInfo userInfo;
    private CircularImageView img_head;
    private EditText ed_nickname;
    public final static int PHOTO_ZOOM = 0;
    public final static int TAKE_PHOTO = 1;
    public final static int PHOTO_RESULT = 2;
    public static final String IMAGE_UNSPECIFIED = "image/*";
    private String imageDir;
    private Uri imageUri;
    private Dialog dialog;
    private Button btn_save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filldata);
        init();
        initData();

    }
    private void init() {
        sp_prov = (Spinner) findViewById(R.id.sp_prov);
        sp_city = (Spinner) findViewById(R.id.sp_city);
        img_head = (CircularImageView) findViewById(R.id.img_head);
        img_head.setOnClickListener(this);
        rg_sex = (RadioGroup) findViewById(R.id.rg_sex);
        rgbtn_boy = (RadioButton) findViewById(R.id.rbtn_boy);
        rgbtn_girl = (RadioButton) findViewById(R.id.rbtn_girl);
        rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rgbtn_boy.getImeActionId()) {
                    userInfo.setSex(true);
                } else
                    userInfo.setSex(false);
            }
        });
        btn_save= (Button)findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);



    }

    private void initData() {
        initProvinces();
        initAllCity();
        initSpinnerData();
        userInfo = new UserInfo(MoXingData.user_id);
        initInfo();

    }

    private void initSpinnerData() {
        //ArrayAdapter<>
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
                userInfo.setPositionProv(list_prov.get(position).getName());
                initCity(list_prov.get(position).getProID());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userInfo.setPositionCity(list_city.get(position).getName());
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

    private void initInfo() {
        userInfo.setHeadimgUrl("");
        userInfo.setNickname("未设置");
        userInfo.setSex(true);
        userInfo.setPositionProv("北京");
        userInfo.setPositionCity("北京");
        userInfo.setUserId(MoXingData.user_id);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_head:
                dialog = new SelectHeadPicDialog(this, itemsOnClick);
                dialog.show();
                break;
            case R.id.btn_save:
                updateUserInfo();
                break;
        }
    }

    private View.OnClickListener itemsOnClick = new View.OnClickListener() {

        public void onClick(View v) {
            dialog.dismiss();
            switch (v.getId()) {
                case R.id.tv_call_camera:
                    imageDir = "temp.jpg";
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(new File(Environment.getExternalStorageDirectory(), imageDir)));
                    startActivityForResult(intent, TAKE_PHOTO);
                    break;
                case R.id.tv_call_gallery:
                    File outputImage = new File(Environment.getExternalStorageDirectory(), "output_Image.jpg");
                    try {
                        if (outputImage.exists()) {
                            outputImage.delete();
                        }
                        outputImage.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    imageUri = Uri.fromFile(outputImage);
                    Intent intent2 = new Intent("android.intent.action.PICK");
                    intent2.setType("image/*");
                    intent2.putExtra("crop", true);
                    intent2.putExtra("scale", true);
                    intent2.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

                    startActivityForResult(intent2, PHOTO_ZOOM);//参数传TAKE_PHOTO
                    break;
                default:
                    break;
            }


        }

    };

    public void photoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, IMAGE_UNSPECIFIED);
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        intent.putExtra("return-data", true);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, PHOTO_RESULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == PHOTO_ZOOM) {
                photoZoom(data.getData());
            }
            if (requestCode == TAKE_PHOTO) {
                File picture = new File(Environment.getExternalStorageDirectory() + "/" + imageDir);
                photoZoom(Uri.fromFile(picture));
            }

            if (requestCode == PHOTO_RESULT) {
                Bundle extras = data.getExtras();
                if (extras != null) {
                    final Bitmap photo = extras.getParcelable("data");
                    ByteArrayOutputStream bStream = new ByteArrayOutputStream();
                    photo.compress(Bitmap.CompressFormat.JPEG, 30, bStream);
                    byte[] bytes = bStream.toByteArray();
                    String ss = Base64.encodeToString(bytes, Base64.DEFAULT);
                   // Log.e("photo", ss);
                   /* OkGo.post(MoXingUrl.uploadHeadImg).tag("fill").params("img", ss).execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, okhttp3.Call call, okhttp3.Response response) {
                            //Log.e("img",s);
                            ResponseObj responseObj = new Gson().fromJson(s, ResponseObj.class);
                            if (responseObj.getCode() == 1) {
                                Log.e("img_file", responseObj.getData().toString());
                            }
                        }
                    });*/
                    OkGo.post(MoXingUrl.uploadHeadImg).tag("fill").params("img", ss).execute(new JsonCallback<ResponseObj>(ResponseObj.class) {
                        @Override
                        public void onSuccess(ResponseObj responseObj, Call call, Response response) {
                            if (responseObj.getCode() == 1) {
                               // Log.e("img_file", responseObj.getData().toString());
                                if(!TextUtils.isEmpty(responseObj.getData().toString())){
                                    userInfo.setHeadimgUrl(responseObj.getData().toString());
                                    img_head.setImageBitmap(photo);
                                }
                            }

                        }
                    });

                }
                }
        }
    }
    private void updateUserInfo(){
        if(!TextUtils.isEmpty(userInfo.getHeadimgUrl())&&
        !TextUtils.isEmpty(userInfo.getNickname())&&
                !TextUtils.isEmpty(userInfo.getPositionProv())&&
                !TextUtils.isEmpty(userInfo.getPositionCity()))
        {
            OkGo.post(MoXingUrl.updateUserInfo).params("headimgUrl",userInfo.getHeadimgUrl()).params("userId",userInfo.getUserId())
                    .params("nickname", userInfo.getNickname()).params("positionProv",userInfo.getPositionProv())
                    .params("positionCity",userInfo.getPositionCity()).params("sex",userInfo.getSex()).execute(new JsonCallback<ResponseObj>(ResponseObj.class) {
                @Override
                public void onSuccess(ResponseObj responseObj, Call call, Response response) {
                    Log.e("update", responseObj.getCode()+"");
                }
            });
        }
    }
}

