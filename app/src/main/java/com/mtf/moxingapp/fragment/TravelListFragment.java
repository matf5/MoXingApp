package com.mtf.moxingapp.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.mtf.moxingapp.R;
import com.mtf.moxingapp.adapter.TravelListAdapter;
import com.mtf.moxingapp.callback.JsonCallback;
import com.mtf.moxingapp.json.TravelJson;
import com.mtf.moxingapp.model.ResponseObj;
import com.mtf.moxingapp.util.MoXingUrl;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/1/9.
 */
public class TravelListFragment extends LazyFragment{
    private View rootView;

    private RecyclerView recyclerView;
    private List<TravelJson.DataBean> beanList = new ArrayList<TravelJson.DataBean>();
    private TravelListAdapter travelListAdapter;
    private  SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_travel_list);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        initView();
    }

    private void initView() {

        initRecyclerview();

    }

    private void initRecyclerview() {
        travelListAdapter = new TravelListAdapter(getContext(),beanList);
        addSomething2Travel();
        recyclerView=(RecyclerView)findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(travelListAdapter);
        
    }

    private void addSomething2Travel() {
        OkGo.post(MoXingUrl.travelList).params("userId", "2").execute(new JsonCallback<TravelJson>(TravelJson.class) {
            @Override
            public void onSuccess(TravelJson travelJson, Call call, Response response) {
                if (travelJson.getCode() == 1) {
                    beanList.addAll(travelJson.getData());
                    travelListAdapter.notifyDataSetChanged();
                }
            }


        });
      /*  Log.e("travelshow", "111");
       String travelJson = "{\"code\":1,\"msg\":\"成功返回相同目的地的未过期行程！\",\"data\":[{\"id\":3,\"userId\":3,\"title\":\"出游\",\"description\":\"halo,Beijing\",\"beginDate\":\"Jan 20, 2017 12:00:00 AM\",\"endDate\":\"Jan 25, 2017 12:00:00 AM\",\"beginPosProv\":\"广东\",\"beginPosCity\":\"广州\",\"destPosProv\":\"北京\",\"destPosCity\":\"北京\",\"imgUrl\":\"www.taobao.com\",\"state\":0,\"longitude\":\"56.34\",\"latitude\":\"45.23\",\"isExpired\":false,\"userInfo\":{\"id\":3,\"longitude\":\"56.34\",\"latitude\":\"45.23\",\"userId\":3},\"label\":{\"id\":3,\"userId\":3},\"flag\":false},{\"id\":4,\"userId\":9,\"title\":\"出游\",\"description\":\"halo, Beijing\",\"beginDate\":\"Jan 20, 2017 12:00:00 AM\",\"endDate\":\"Jan 27, 2017 12:00:00 AM\",\"beginPosProv\":\"广东\",\"beginPosCity\":\"广州\",\"destPosProv\":\"北京\",\"destPosCity\":\"北京\",\"imgUrl\":\"www.taobao.com\",\"state\":0,\"longitude\":\"56.23\",\"latitude\":\"25.56\",\"isExpired\":false,\"userInfo\":{\"id\":4,\"longitude\":\"56.23\",\"latitude\":\"25.56\",\"userId\":9},\"label\":{\"id\":4,\"userId\":9},\"flag\":false}]}";
       TravelJson  traveljson1= new Gson().fromJson(travelJson,TravelJson.class);
        beanList.addAll(traveljson1.getData());
        Log.e("travelshow",traveljson1.getData().toString());*/


    }






}
