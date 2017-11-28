package jljt.wangs.com.CustonView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/11/28.
 */

public class ITaiJi extends View{
    private float degrees;//角度
    private Paint whitePaint;//白色画笔
    private Paint blackPaint;//黑色画笔
    public ITaiJi(Context context) {
        this(context,null);
    }

    public ITaiJi(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ITaiJi(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
    }

    /**
     * 初始化画笔函数
     */
    private void initPaints(){
        whitePaint=new Paint();
        whitePaint.setColor(Color.WHITE);
        whitePaint.setAntiAlias(true);//抗锯齿

        blackPaint=new Paint();
        blackPaint.setAntiAlias(true);
        blackPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 确定画布大小
         */
        int width=canvas.getWidth();
        int height=canvas.getHeight();
        /**
         * 将canvas坐标原点移动到画布中心
         */
        canvas.translate(width/2,height/2);
        /**
         * 绘制背景色
         */
        canvas.drawColor(Color.GRAY);
        /**
         * 旋转画布
         */
        canvas.rotate(degrees);
        /**
         * 绘制两个半圆
         */
        int radius=Math.min(width,height)/2-100;//太极半径
        RectF rectF=new RectF(-radius,-radius,radius,radius);//绘制区域
        canvas.drawArc(rectF, 90, 180, true, blackPaint);            //绘制黑色半圆
        canvas.drawArc(rectF, -90, 180, true, whitePaint);           //绘制白色半圆
        /**
         * 绘制两个小圆
         */
        int smallRadius=radius/2;
        canvas.drawCircle(0,-smallRadius,smallRadius,blackPaint);
        canvas.drawCircle(0,smallRadius,smallRadius,whitePaint);
        /**
         * 绘制鱼眼
         */
        canvas.drawCircle(0,-smallRadius,smallRadius/4,whitePaint);
        canvas.drawCircle(0,smallRadius,smallRadius/4,blackPaint);
    }

    /**
     * 旋转并重新绘制界面
     * @param degrees
     */
    public void setRotate(float degrees){
        this.degrees=degrees;
        invalidate();//重新绘制
    }
}
