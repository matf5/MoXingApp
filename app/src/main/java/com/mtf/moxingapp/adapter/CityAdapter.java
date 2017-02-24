package com.mtf.moxingapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mtf.moxingapp.R;
import com.mtf.moxingapp.model.City;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */
public class CityAdapter extends BaseAdapter {
    private List<City> list_city;
    private Context context;
    @Override
    public int getCount() {
        return list_city.size();
    }

    public CityAdapter( Context context,List<City> list_city) {
        this.list_city = list_city;
        this.context = context;
    }

    @Override
    public Object getItem(int position) {
        return list_city.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.tv_spinner,null);
        if(convertView!=null){
            TextView tv_spinner = (TextView)convertView.findViewById(R.id.tv_spinner);
            tv_spinner.setText(list_city.get(position).getName());
        }
        return convertView;
    }
}
