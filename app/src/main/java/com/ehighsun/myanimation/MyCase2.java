package com.ehighsun.myanimation;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/1/9 0009.
 */

public class MyCase2 extends View {
    private Paint mPaint;
    private PointF mCurrentPoint;
    private float mRadius = 50f;

    public MyCase2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(mCurrentPoint==null){
            mCurrentPoint = new PointF(mRadius,mRadius);
            drawCircle(canvas);
            startAnimation();
        }else {
            drawCircle(canvas);
        }
    }


    private void startAnimation(){
        PointF startPoint = new PointF(mRadius,mRadius);
        PointF endPoint = new PointF(getWidth()-mRadius,getHeight()-mRadius);
        ValueAnimator animator = ValueAnimator.ofObject(new MyEvaluate(),startPoint,endPoint);
        animator.setDuration(5000);
        animator.setInterpolator(new DecelerateAccelerateInterpolator());
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrentPoint = (PointF) animation.getAnimatedValue();
                invalidate();
            }
        });

    }

    private void drawCircle(Canvas canvas) {
        float x = mCurrentPoint.x;
        float y = mCurrentPoint.y;
        canvas.drawCircle(x,y,mRadius,mPaint);
    }

    private class MyEvaluate implements TypeEvaluator{

        @Override
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            PointF startPoint = (PointF) startValue;
            PointF endPoint = (PointF) endValue;
            float x = startPoint.x + fraction*(endPoint.x-startPoint.x);
            float y = startPoint.y+ fraction*(endPoint.y-startPoint.y);
            PointF point = new PointF(x,y);
            return point;
        }
    }

    private class DecelerateAccelerateInterpolator implements TimeInterpolator{

        @Override
        public float getInterpolation(float input) {
            float result;
            if (input <= 0.5) {
                result = (float) (Math.sin(Math.PI * input)) / 2;
            } else {
                result = (float) (2 - Math.sin(Math.PI * input)) / 2;
            }
            return result;
        }
    }
}
