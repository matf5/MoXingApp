package com.mtf.moxingapp.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtf.moxingapp.R;

/**
 * Created by Administrator on 2017/1/9.
 */
public class ChatFragment extends LazyFragment {
    private RecyclerView recyclerView;
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_travel_list);
        init();
    }

    private void init() {

    }
}
