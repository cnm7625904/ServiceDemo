package jljt.wangs.com.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/11/24.
 */

public class Bind_Serviece extends Service{
    private DownloadBinder downloadBinder=new DownloadBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("service","绑定服务");
        return downloadBinder;
    }
    /**
     * 内部类集成Binder
     */
public class DownloadBinder extends Binder{
    public void startDownLoad(){
        Log.e("service","开始下载");
    }
    public void getProgress(){
        Log.e("service","获取下载进度");
    }
    }

    /**
     * 创建服务
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("service","创建服务");
    }
    /**
     * 开始服务
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("service","开始服务");
        return super.onStartCommand(intent, flags, startId);
    }
    /**
     * 销毁服务
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("service","销毁服务");
    }
}
