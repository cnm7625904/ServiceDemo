package jljt.wangs.com.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import jljt.wangs.com.BroadCastReceiverDemo.Dynamic_BroadCast;
import jljt.wangs.com.Constants.ConmonConstants;
import jljt.wangs.com.CustonView.IShowTaiji;
import jljt.wangs.com.CustonView.ShowTaiji;
import jljt.wangs.com.CustonView.Taiji;
import jljt.wangs.com.CustonView.Test;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Bind_Serviece.DownloadBinder downloadBinder;
    private  Intent intentBind;
    private Boolean isConnect=false;
    private Dynamic_BroadCast dynamicBroadCast;//动态注册
    //private Bind_Serviece bindServiece;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.start_service).setOnClickListener(this);
        findViewById(R.id.stop_service).setOnClickListener(this);
        findViewById(R.id.bind_service).setOnClickListener(this);
        findViewById(R.id.unbind_service).setOnClickListener(this);
        findViewById(R.id.btn_staticbroadcast).setOnClickListener(this);
        findViewById(R.id.btn_dynamicbroadcast).setOnClickListener(this);
        findViewById(R.id.btn_taiji).setOnClickListener(this);
        dynamicBroadCast=new Dynamic_BroadCast();//动态NEW注册广播
    }
    @Override
    public void onClick(View view) {
        int viewId=view.getId();
        switch (viewId){
            case R.id.start_service:
                Intent intentStart=new Intent(MainActivity.this,MyService.class);
                startService(intentStart);
                break;
            case R.id.stop_service:
                Intent intentStop=new Intent(MainActivity.this,MyService.class);
                stopService(intentStop);
                break;
            case R.id.bind_service:
                intentBind=new Intent(MainActivity.this,Bind_Serviece.class);
                bindService(intentBind,connection,BIND_AUTO_CREATE);
                isConnect=true;
                break;
            case R.id.unbind_service:
                if(isConnect){
                    unbindService(connection);
                    isConnect=false;
                }
                else if(!isConnect){
                    Toast.makeText(MainActivity.this,"服务都没有怎么取消？",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_staticbroadcast:
                Intent staticIntent=new Intent();
                staticIntent.putExtra("key","静态注册");
                staticIntent.setAction(ConmonConstants.STATIC_BROADCAST);
                sendBroadcast(staticIntent);
                Toast.makeText(MainActivity.this,"这是静态？",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_dynamicbroadcast:
                Intent dynamicIntent=new Intent();
                dynamicIntent.putExtra("key","动态注册");
                dynamicIntent.setAction(ConmonConstants.DYNAMIC_BROADCAST);
                sendBroadcast(dynamicIntent);
                Toast.makeText(MainActivity.this,"这是动态？",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_taiji:
                startActivity(new Intent(MainActivity.this, IShowTaiji.class));
                break;
            default:
                break;
        }
    }
    private ServiceConnection connection=new ServiceConnection() {
        /**
         * 绑定服务时调用
         * @param componentName
         * @param iBinder
         */
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downloadBinder= (Bind_Serviece.DownloadBinder) iBinder;
            /**
             * 调用downloadBinder方法实现参数的传递
             */
            downloadBinder.startDownLoad();
            downloadBinder.getProgress();
        }
        /**
         * 解除绑定时调用
         * @param componentName
         */
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        //设置过滤器
        IntentFilter filter=new IntentFilter();
        filter.addAction(ConmonConstants.DYNAMIC_BROADCAST);
        registerReceiver(dynamicBroadCast,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dynamicBroadCast);
    }
}
