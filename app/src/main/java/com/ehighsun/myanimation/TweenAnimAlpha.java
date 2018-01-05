package com.ehighsun.myanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class TweenAnimAlpha extends AppCompatActivity implements View.OnClickListener {
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
        alphaAnimation = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
        ivImg.startAnimation(alphaAnimation);
    }

    private void loadAnim2() {
        alphaAnimation = new AlphaAnimation(0f,1f);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setFillAfter(false);
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
