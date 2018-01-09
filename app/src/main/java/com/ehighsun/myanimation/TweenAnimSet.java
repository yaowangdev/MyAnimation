package com.ehighsun.myanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class TweenAnimSet extends AppCompatActivity implements View.OnClickListener {
    private AnimationSet animationSet;
    private Button btnStart,btnStop;
    private ImageView ivImg;

/*AccelerateInterpolator 加速，开始时慢中间加速

DecelerateInterpolator 减速，开始时快然后减速

AccelerateDecelerateInterolator 先加速后减速，开始结束时慢，中间加速

AnticipateInterpolator 反向，先向相反方向改变一段再加速播放

AnticipateOvershootInterpolator 反向加超越，先向相反方向改变，再加速播放，会超出目的值然后缓慢移动至目的值

BounceInterpolator 跳跃，快到目的值时值会跳跃，如目的值100，后面的值可能依次为85，77，70，80，90，100

CycleIinterpolator 循环，动画循环一定次数，值的改变为一正弦函数：Math.sin(2* mCycles* Math.PI* input)

LinearInterpolator 线性，线性均匀改变

OvershootInterpolator超越，最后超出目的值然后缓慢改变到目的值*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_anim_alpha);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStop = (Button) findViewById(R.id.btn_stop);
        ivImg = (ImageView) findViewById(R.id.iv_alpha_img);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
//        loadAnim1();//
        loadAnim2();
    }

    private void loadAnim1() {
        animationSet = (AnimationSet) AnimationUtils.loadAnimation(this,R.anim.anim_set);
        ivImg.startAnimation(animationSet);
    }

    private void loadAnim2() {
        animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f,1f);
        alphaAnimation.setDuration(2000);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f,0.5f,1f,0.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setInterpolator(this,android.R.anim.linear_interpolator);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        ivImg.startAnimation(animationSet);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                if (animationSet!=null && animationSet.hasEnded()){
                    ivImg.startAnimation(animationSet);
                }

                break;
            case R.id.btn_stop:
                if (animationSet!=null && !animationSet.hasEnded()){
                    animationSet.cancel();
                }
                break;
        }
    }
}
