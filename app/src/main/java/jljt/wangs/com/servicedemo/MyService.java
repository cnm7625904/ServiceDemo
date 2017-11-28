package jljt.wangs.com.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/11/24.
 */

public class MyService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 创建服务时调用
     */
    @Override
    public void onCreate() {
        super.onCreate();
//        System.out.println("创建服务");
        Log.e("serviece","创建服务");
    }
    /**
     * 启动服务的时候调用
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        System.out.println("启动服务");w
        Log.e("serviece","启动服务");
        return super.onStartCommand(intent, flags, startId);
    }
    /**
     * 销毁服务的时候调用
     */
    @Override
    public void onDestroy() {
//        System.out.println("销毁服务");
        Log.e("serviece","销毁服务");
        super.onDestroy();
    }
}
