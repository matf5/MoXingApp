package com.mtf.moxingapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mtf.moxingapp.R;
import com.mtf.moxingapp.json.MatchJson;

import java.util.List;

/**
 * Created by Administrator on 2017/3/19.
 */
public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatListViewHolder> {
    private Context context;
    private List<MatchJson.DataBean> beanList;

    public ChatListAdapter(Context context, List<MatchJson.DataBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public ChatListAdapter.ChatListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChatListViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_chat, parent,
                false));
    }

    @Override
    public void onBindViewHolder(ChatListAdapter.ChatListViewHolder holder, int position) {
        MatchJson.DataBean match = beanList.get(position);
        holder.tv_name.setText(match.getNickname());
        holder.tv_content.setText(match.getPosProv()+match.getPosCity());
        //holder.tv_content.setText();

    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public static class ChatListViewHolder extends RecyclerView.ViewHolder {
        public ImageView img_head;
        public TextView tv_name;
        public TextView tv_content;
        public TextView tv_state;

        public TextView tv_seedetail;
        public TextView tv_chatwith;
        public ChatListViewHolder(View itemView) {
            super(itemView);
            img_head = (ImageView)itemView.findViewById(R.id.img_head);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            tv_state = (TextView) itemView.findViewById(R.id.tv_state);
            tv_seedetail = (TextView) itemView.findViewById(R.id.tv_seedetail);
            tv_chatwith = (TextView) itemView.findViewById(R.id.tv_chatwith);
        }
    }
}
