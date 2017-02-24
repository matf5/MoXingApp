package com.mtf.moxingapp.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.mtf.moxingapp.R;
import com.mtf.moxingapp.callback.JsonCallback;
import com.mtf.moxingapp.model.ResponseObj;
import com.mtf.moxingapp.model.Travel;
import com.mtf.moxingapp.util.MoXingData;
import com.mtf.moxingapp.util.MoXingUrl;
import com.mtf.moxingapp.util.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/1/25.
 */
public class ReleaseTravelActivity extends AppCompatActivity implements View.OnClickListener{
    private LocationManager locationmanager;
    private String provider;
    private ImageView back;
    private RelativeLayout layout_plan;
    private ImageView img_plan;
    private TextView tv_plan_hint;
    private TextView tv_plan;
    private ImageView next_plan;
    private RelativeLayout layout_start_time;
    private ImageView img_start_time;
    private TextView tv_start_time_hint;
    private TextView tv_start_time;
    private ImageView next_start_time;
    private RelativeLayout layout_end_time;
    private ImageView img_end_time;
    private TextView tv_end_time_hint;
    private TextView tv_end_time;
    private ImageView end_time_next;
    private RelativeLayout layout_start_pos;
    private ImageView img_pos;
    private TextView tv_start_pos_hint;
    private TextView tv_start_pos;
    private ImageView start_pos_next;
    private RelativeLayout layout_end_pos;
    private ImageView img_end_pos;
    private TextView tv_end_pos_hint;
    private TextView tv_end_pos;
    private ImageView end_pos_next;
    private RelativeLayout layout_location;
    private ImageView img_location;
    private TextView tv_location_hint;
    private TextView tv_location;
    private ImageView location_next;
    private RelativeLayout layout_description;
    private TextView tv_description;
    private ImageView img_description;
    private TextView tv_description_hint;
    private ImageView description_next;
    private Calendar calendar=Calendar.getInstance(Locale.CHINA);
    private static  Travel travel= new Travel();
    private android.support.design.widget.FloatingActionButton fab;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release_travel);
        travel = new Travel();
        init();

    }

    private void init() {
        initView();
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        initLocation();

        mLocationClient.registerLocationListener(myListener);
        mLocationClient.start();
    }

    private void initView() {
        layout_plan = (RelativeLayout) findViewById(R.id.layout_plan);
        layout_plan.setOnClickListener(this);
        img_plan = (ImageView) findViewById(R.id.img_plan);
        tv_plan_hint = (TextView) findViewById(R.id.tv_plan_hint);
        tv_plan = (TextView) findViewById(R.id.tv_plan);
        next_plan = (ImageView) findViewById(R.id.next_plan);
        layout_start_time = (RelativeLayout) findViewById(R.id.layout_start_time);
        layout_start_time.setOnClickListener(this);
        img_start_time = (ImageView) findViewById(R.id.img_start_time);
        tv_start_time_hint = (TextView) findViewById(R.id.tv_start_time_hint);
        tv_start_time = (TextView) findViewById(R.id.tv_start_time);
        next_start_time = (ImageView) findViewById(R.id.next_start_time);
        layout_end_time = (RelativeLayout) findViewById(R.id.layout_end_time);
        layout_end_time.setOnClickListener(this);
        img_end_time = (ImageView) findViewById(R.id.img_end_time);
        tv_end_time_hint = (TextView) findViewById(R.id.tv_end_time_hint);
        tv_end_time = (TextView)findViewById(R.id.tv_end_time);
        end_time_next = (ImageView) findViewById(R.id.end_time_next);
        layout_start_pos = (RelativeLayout) findViewById(R.id.layout_start_pos);
        layout_start_pos.setOnClickListener(this);
        img_pos = (ImageView) findViewById(R.id.img_pos);
        tv_start_pos_hint = (TextView) findViewById(R.id.tv_start_pos_hint);
        tv_start_pos = (TextView)findViewById(R.id.tv_start_pos);
        start_pos_next = (ImageView) findViewById(R.id.start_pos_next);
        layout_end_pos = (RelativeLayout) findViewById(R.id.layout_end_pos);
        layout_end_pos.setOnClickListener(this);
        img_end_pos = (ImageView) findViewById(R.id.img_end_pos);
        tv_end_pos_hint = (TextView) findViewById(R.id.tv_end_pos_hint);
        tv_end_pos = (TextView)findViewById(R.id.tv_end_pos);
        end_pos_next = (ImageView) findViewById(R.id.end_pos_next);
        layout_location = (RelativeLayout) findViewById(R.id.layout_location);
        layout_location.setOnClickListener(this);
        img_location = (ImageView) findViewById(R.id.img_location);
        tv_location_hint = (TextView) findViewById(R.id.tv_location_hint);
        tv_location=(TextView)findViewById(R.id.tv_location);
        location_next = (ImageView) findViewById(R.id.location_next);
        layout_description = (RelativeLayout) findViewById(R.id.layout_description);

        layout_description.setOnClickListener(this);
        img_description = (ImageView) findViewById(R.id.img_description);
        tv_description_hint = (TextView) findViewById(R.id.tv_description_hint);
        tv_description = (TextView)findViewById(R.id.tv_description);
        description_next = (ImageView) findViewById(R.id.description_next);
        fab = (android.support.design.widget.FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

    }




    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_location:
                initLocation();
                break;
            case R.id.layout_plan:
                Intent intent = new Intent(ReleaseTravelActivity.this,FillTravelDataActivity.class);
                intent.putExtra(FillTravelDataActivity.TITLE_OR_DESCRI,0);
                startActivityForResult(intent, 0);
                break;
            case R.id.layout_description:
                intent = new Intent(ReleaseTravelActivity.this,FillTravelDataActivity.class);
                intent.putExtra(FillTravelDataActivity.TITLE_OR_DESCRI, 1);
                startActivityForResult(intent, 0);
                break;
            case R.id.layout_start_time:

                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(year, monthOfYear, dayOfMonth);
                        travel.setBeginDate(Util.dateToString(calendar.getTime()));
                        tv_start_time.setText(travel.getBeginDate());
                    }
                },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.layout_end_time:

                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(year,monthOfYear,dayOfMonth);
                        travel.setEndDate(Util.dateToString(calendar.getTime()));
                        tv_end_time.setText(travel.getEndDate());
                    }
                },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.layout_start_pos:
                intent=  new Intent(ReleaseTravelActivity.this,SelectPosActivity.class);
                intent.putExtra(SelectPosActivity.TYPE,0);
                startActivityForResult(intent, 0);
                break;
            case R.id.layout_end_pos:
                intent=  new Intent(ReleaseTravelActivity.this,SelectPosActivity.class);
                intent.putExtra(SelectPosActivity.TYPE,1);
                startActivityForResult(intent, 0);
                break;
            case R.id.fab:
                //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

                //Log.e("release", dateFormat.format(travel.getBeginDate()));

               travel.setImgUrl("111");
                travel.setUserId(MoXingData.user_id);
               /* OkGo.post(MoXingUrl.releaseTravel).tag(this).upJson(new Gson().toJson(travel)).execute(new JsonCallback<ResponseObj>(ResponseObj.class) {
                    @Override
                    public void onSuccess(ResponseObj responseObj, Call call, Response response) {
                        Log.e("releasetravel", responseObj.getCode()+"");
                    }
                });*/
                Log.e("release", new Gson().toJson(travel));
                if(Util.isTravelFilled(travel)) {
                    OkGo.post(MoXingUrl.releaseTravel).tag(this).params("title",travel.getTitle()).params("userId",travel.getUserId())
                            .params("description",travel.getDescription()).params("beginDate",travel.getBeginDate()).params("endDate",travel.getEndDate())
                            .params("beginPosProv",travel.getBeginPosProv()).params("beginPosCity",travel.getBeginPosCity())
                            .params("destPosProv",travel.getDestPosProv()).params("destPosCity",travel.getDestPosCity())
                            .params("imgUrl",travel.getImgUrl()).params("longitude",travel.getLongitude()).params("latitude",travel.getLongitude())
                            .execute(new JsonCallback<ResponseObj>(ResponseObj.class) {
                                @Override
                                public void onSuccess(ResponseObj responseObj, Call call, Response response) {
                                   // Log.e("releasetravel", responseObj.getCode() + "");
                                    if(responseObj.getCode()==1){
                                        Toast.makeText(ReleaseTravelActivity.this,"发布成功",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else{
                   // Log.e("release",travel.);
                    Toast.makeText(ReleaseTravelActivity.this,"请完善信息",Toast.LENGTH_SHORT).show();
                }
                break;
                //OkGo.post(MoXingUrl.releaseTravel).params("userId", MoXingData.user_id).params()


        }

    }
    public static  Travel getTravel(){
        return travel;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) { //resultCode为回传的标记，我在B中回传的是RESULT_OK
            case RESULT_OK:
                setData();
                break;
            default:
                break;
        }
    }
    private void setData(){
        if(!TextUtils.isEmpty(travel.getTitle()))
            tv_plan.setText(travel.getTitle());
        if(!TextUtils.isEmpty(travel.getBeginPosCity())&&!TextUtils.isEmpty(travel.getBeginPosProv()))
            tv_start_pos.setText(travel.getBeginPosProv()+travel.getBeginPosCity());
        if (!TextUtils.isEmpty(travel.getDestPosProv())&&!TextUtils.isEmpty(travel.getDestPosProv()))
            tv_end_pos.setText(travel.getDestPosProv()+travel.getDestPosCity());
        if (travel.getDescription()!=null)
            tv_description.setText(travel.getDescription());

    }
    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {

            //获取定位结果
            StringBuffer sb = new StringBuffer(256);

            sb.append("time : ");
            sb.append(location.getTime());    //获取定位时间

            sb.append("\nerror code : ");
            sb.append(location.getLocType());    //获取类型类型

            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());    //获取纬度信息
            travel.setLatitude(location.getLatitude() + "");
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());    //获取经度信息
            travel.setLongitude(location.getLongitude()+"");

            sb.append("\nradius : ");
            sb.append(location.getRadius());    //获取定位精准度

            if (location.getLocType() == BDLocation.TypeGpsLocation){

                // GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());    // 单位：公里每小时

                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());    //获取卫星数

                sb.append("\nheight : ");
                sb.append(location.getAltitude());    //获取海拔高度信息，单位米

                sb.append("\ndirection : ");
                sb.append(location.getDirection());    //获取方向信息，单位度

                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息

                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation){

                // 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息

                sb.append("\noperationers : ");
                sb.append(location.getOperators());    //获取运营商信息

                sb.append("\ndescribe : ");
                sb.append("网络定位成功");

            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {

                // 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");

            } else if (location.getLocType() == BDLocation.TypeServerError) {

                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");

            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {

                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");

            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {

                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");

            }

            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());    //位置语义化信息
            tv_location.setText(location.getAddrStr());
            List<Poi> list = location.getPoiList();    // POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }

            Log.i("BaiduLocationApiDem", sb.toString());
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }
    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备

        option.setCoorType("bd09ll");
        //可选，默认gcj02，设置返回的定位结果坐标系

        int span=1000;
        option.setScanSpan(span);
        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的

        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要

        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps

        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果

        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”

        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死

        option.SetIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集

        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

        mLocationClient.setLocOption(option);
    }


}
