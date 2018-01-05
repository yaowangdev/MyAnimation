package com.ehighsun.myanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class TweenAnimRotate extends AppCompatActivity implements View.OnClickListener {
    private Animation alphaAnimation;
    private Button btnStart,btnStop;
    private ImageView ivImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_anim_alpha);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStop = (Button) findViewById(R.id.btn_stop);
        ivImg = (ImageView) findViewById(R.id.iv_alpha_img);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
//        loadAnim1();//xml
        loadAnim2();//java代码
    }

    private void loadAnim1() {
        alphaAnimation = AnimationUtils.loadAnimation(this,R.anim.anim_rotate);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setInterpolator(this,android.R.anim.linear_interpolator);
        ivImg.startAnimation(alphaAnimation);
    }

    private void loadAnim2() {
        alphaAnimation = new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(false);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setInterpolator(this,android.R.anim.linear_interpolator);
        ivImg.startAnimation(alphaAnimation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                if (alphaAnimation!=null && alphaAnimation.hasEnded()){
                    ivImg.startAnimation(alphaAnimation);
                }

                break;
            case R.id.btn_stop:
                if (alphaAnimation!=null && !alphaAnimation.hasEnded()){
                    alphaAnimation.cancel();
                }
                break;
        }
    }
}
