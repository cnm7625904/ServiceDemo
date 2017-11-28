package jljt.wangs.com.BroadCastReceiverDemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/11/27.
 * 动态广播
 */

public class Dynamic_BroadCast extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"动态注册成功",Toast.LENGTH_SHORT).show();
    }
}
