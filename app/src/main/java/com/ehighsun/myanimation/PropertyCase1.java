package com.ehighsun.myanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PropertyCase1 extends AppCompatActivity implements View.OnClickListener {
    private TextView tvText;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_case1);
        btnStart = (Button) findViewById(R.id.btn_start);
        tvText = (TextView) findViewById(R.id.tv_animation);
        btnStart.setOnClickListener(this);
//        initAnimator1();
        initAnimator2();
    }



    private void initAnimator1() {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(tvText,"translationX",-600f,0f,600f,0f,-600f,0f,600f,0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(tvText,"rotation",0f,360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(tvText,"alpha",1f,0f,1f);
        moveIn.setDuration(500);
        rotate.setDuration(2000);
        fadeInOut.setDuration(2000);
        AnimatorSet set = new AnimatorSet();
        set.play(rotate).with(fadeInOut).after(moveIn);
        set.start();
    }

    private void initAnimator2() {
        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.anim_property_set1);
        animator.setTarget(tvText);
        animator.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
//                initAnimator1();
                initAnimator2();
                break;
        }
    }
}
