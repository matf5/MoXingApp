package com.mtf.moxingapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mtf.moxingapp.R;
import com.mtf.moxingapp.json.MessageJson;
import com.mtf.moxingapp.util.MoXingData;

import java.util.List;

/**
 * Created by Administrator on 2017/3/23.
 */
public class ChatAdapter  extends RecyclerView.Adapter<ChatAdapter.ViewHolder>{
    private List<MessageJson.DataBean> beanList;
    private Context context;

    public ChatAdapter(List<MessageJson.DataBean> beanList, Context context) {
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_me_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {
        MessageJson.DataBean message = beanList.get(position);
        if(Integer.toString(message.getSendId()).equals(MoXingData.user_id)){
            holder.tv_me.setText(message.getContent().toString());
        }
        else{
            holder.tv_him.setText(message.getContent().toString());
        }

    }
    public   class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_me;
        public TextView tv_him;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_me = (TextView) itemView.findViewById(R.id.tv_me);
            tv_him = (TextView) itemView.findViewById(R.id.tv_him);
        }
    }
    @Override
    public int getItemCount() {
        return beanList.size();
    }
}
