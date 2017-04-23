package com.mtf.moxingapp.receiver;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.baidu.android.pushservice.PushMessageReceiver;

import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */
public class MyPushMessageReceiver extends PushMessageReceiver {
    public final static String TAG="IMESSAGE";
    @Override

    public void onBind(Context context, int errorCode, String appid,
                       String userId, String channelId, String requestId) {
        String responseString = "onBind errorCode=" + errorCode + " appid="
                + appid + " userId=" + userId + " channelId=" + channelId
                + " requestId=" + requestId;
        Log.d(TAG, responseString);

        if (errorCode == 0) {
            // 绑定成功
            Log.d(TAG, "绑定成功");
        }

        // Demo更新界面展示代码，应用请在这里加入自己的处理逻辑

    }


    @Override
    public void onUnbind(Context context, int i, String s) {
        Log.i(TAG,s+"unbind");
    }

    @Override
    public void onSetTags(Context context, int i, List<String> list, List<String> list1, String s) {
        Log.i(TAG,s+"setTages");
    }

    @Override
    public void onDelTags(Context context, int i, List<String> list, List<String> list1, String s) {
        Log.i(TAG,s+"delTags");
    }

    @Override
    public void onListTags(Context context, int i, List<String> list, String s) {
        Log.i(TAG,s+"listTags");
    }

    @Override
    public void onMessage(Context context, String s, String s1) {
        Log.i(TAG,s+"onmessage");
    }

    @Override
    public void onNotificationClicked(Context context, String s, String s1, String s2) {
        Log.i(TAG,s+"click");
    }

    @Override
    public void onNotificationArrived(Context context, String s, String s1, String s2) {
        Log.i(TAG,s+"arrive");
    }
}
