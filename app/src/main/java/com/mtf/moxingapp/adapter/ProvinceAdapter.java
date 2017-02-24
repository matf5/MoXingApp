package com.mtf.moxingapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mtf.moxingapp.R;
import com.mtf.moxingapp.model.Province;

import java.util.List;

/**
 * Created by Administrator on 2017/1/3.
 */
public class ProvinceAdapter extends BaseAdapter {
    private List<Province> list_prov;
    private Context context;
    public ProvinceAdapter(Context context,List<Province>list_prov){
        this.context=context;
        this.list_prov=list_prov;
    }
    @Override
    public int getCount() {
        return list_prov.size();
    }

    @Override
    public Object getItem(int position) {
        return list_prov.get(position);
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
            tv_spinner.setText(list_prov.get(position).getName());
        }
        return convertView;
    }
}
