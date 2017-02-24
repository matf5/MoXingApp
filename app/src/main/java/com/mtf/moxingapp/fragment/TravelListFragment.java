package com.mtf.moxingapp.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtf.moxingapp.R;

/**
 * Created by Administrator on 2017/1/9.
 */
public class TravelListFragment extends BaseFragment{
    private View rootView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        initView();
    }

    private void initView() {
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
        recyclerView = (RecyclerView)findViewById(R.id.recycleView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_travel_list, null);
        }
        // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }


        return rootView;
    }
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
//        MobclickAgent.onPageEnd(TAG);
    }

    @Override
    public void onResume() {
        super.onResume();
//        MobclickAgent.onPageStart(TAG);
    }

}