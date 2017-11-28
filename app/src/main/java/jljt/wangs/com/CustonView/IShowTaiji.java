package jljt.wangs.com.CustonView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import jljt.wangs.com.servicedemo.R;

/**
 * Created by Administrator on 2017/11/28.
 */

public class IShowTaiji extends AppCompatActivity {
    private ITaiJi itaiji;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_itaiji);
        itaiji=findViewById(R.id.itaiji);
        Handler handler=new Handler(){
          private float degree=0;
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            itaiji.setRotate(degree+=7);
            this.sendEmptyMessageDelayed(0,1);
            }

        };
    handler.sendEmptyMessageDelayed(0,1);
    }
}
