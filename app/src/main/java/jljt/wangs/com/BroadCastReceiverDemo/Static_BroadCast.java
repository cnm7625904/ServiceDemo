package jljt.wangs.com.BroadCastReceiverDemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/11/27.
 * 静态广播
 */

public class Static_BroadCast extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String key=intent.getStringExtra("key");
        Toast.makeText(context, key+"静态广播", Toast.LENGTH_SHORT).show();
    }
}
