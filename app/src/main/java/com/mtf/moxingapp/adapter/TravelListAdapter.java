package com.mtf.moxingapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.mtf.moxingapp.R;
import com.mtf.moxingapp.json.TravelJson;
import com.mtf.moxingapp.util.MoXingData;
import com.mtf.moxingapp.util.Util;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
public class TravelListAdapter extends RecyclerView.Adapter<TravelListAdapter.TravelListViewHolder> {
    private Context context;
    private List<TravelJson.DataBean> beanList;

    public TravelListAdapter(Context context, List<TravelJson.DataBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public TravelListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TravelListViewHolder(LayoutInflater.from(
                context).inflate(R.layout.travel_list_item, parent,
                false));

    }

    @Override
    public void onBindViewHolder(TravelListViewHolder holder, int position) {
        TravelJson.DataBean travel  = beanList.get(position);
        Log.e("travelshow", MoXingData.longtitude + "");
        holder.tv_title.setText(beanList.get(position).getTitle());
        holder.tv_name.setText(beanList.get(position).getUserInfo().getNickname());

        holder.tv_dist.setText(Util.getDistancce(MoXingData.longtitude,MoXingData.latitude,travel.getLongitude(),travel.getLatitude())+"");
        holder.tv_date_start.setText(Util.dateToString(travel.getBeginDate()));
        holder.tv_date_end.setText(Util.dateToString(travel.getEndDate()));
        if(!TextUtils.isEmpty(travel.getUserInfo().getHeadimgUrl()))
        Picasso.with(context).load(travel.getUserInfo().getHeadimgUrl()).fit().into(holder.img_head);

    }


    @Override
    public int getItemCount() {
        Log.e("travelshow",beanList.size()+"");
        return beanList.size();
    }

    public static class TravelListViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_title;
        public TextView tv_name;
        public TextView tv_dist;
        public TextView tv_date_start;
        public TextView tv_date_end;
        public ImageView img_head;
        public TextView tv_match_degree;
        public CheckBox cb_like;

        public TravelListViewHolder(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_dist = (TextView) view.findViewById(R.id.tv_dist);

            tv_date_start = (TextView) view.findViewById(R.id.tv_date_start);
            tv_date_end = (TextView) view.findViewById(R.id.tv_date_end);
            img_head = (ImageView) view.findViewById(R.id.img_head);
            tv_match_degree = (TextView) view.findViewById(R.id.tv_match_degree);
            cb_like = (CheckBox) view.findViewById(R.id.cb_like);

        }
    }
}
