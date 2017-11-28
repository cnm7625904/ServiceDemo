package jljt.wangs.com.CustonView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/11/27.
 */

public class SloopView extends View{
//    private Canvas canvas;
    //1、创建画笔
    private Paint mPaint=new Paint();
    public SloopView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
//        canvas.drawPoint(200,200,mPaint);
    }
    public SloopView(Context context){
        super(context, null);
       initPaint();
//        canvas.drawPoint(200,200,mPaint);
    }
    //2、初始化画笔
    private void initPaint(){
        mPaint.setColor(Color.BLACK);//设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);//画笔模式为填充
        mPaint.setStrokeWidth(10f);//设置画笔宽度为10px
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    canvas.drawPoint(200,200,mPaint);
    }
}
