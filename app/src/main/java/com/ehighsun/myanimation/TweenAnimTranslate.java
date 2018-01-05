package com.ehighsun.myanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class TweenAnimTranslate extends AppCompatActivity implements View.OnClickListener {
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
//        loadAnim1();//
        loadAnim2();
    }

    private void loadAnim1() {
        alphaAnimation = AnimationUtils.loadAnimation(this,R.anim.anim_translate);
        ivImg.startAnimation(alphaAnimation);
    }

    private void loadAnim2() {
//        alphaAnimation = new ScaleAnimation(0f,1f,0f,1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        alphaAnimation = new TranslateAnimation(0f,100f,0f,100f);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setFillAfter(false);
        alphaAnimation.setRepeatCount(5);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setInterpolator(this,android.R.anim.overshoot_interpolator);
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
