package jljt.wangs.com.CustonView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import jljt.wangs.com.servicedemo.R;

/**
 * Created by Administrator on 2017/11/27.
 */

public class ShowTaiji extends AppCompatActivity{
    private CustomViews customViews;
    private SloopView sv;
    private Taiji taiji;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.layout_taiji);
        sv=findViewById(R.id.sv);
        taiji=findViewById(R.id.taiji);
        final Handler handler = new Handler() {
            private float degrees = 0;
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                taiji.setRotate(degrees += 5);
                this.sendEmptyMessageDelayed(0, 80);
            }
        };

        handler.sendEmptyMessageDelayed(0, 20);
//        customViews = (CustomViews) findViewById(R.id.cv);
//        new Thread(customViews).start();
    }
}
