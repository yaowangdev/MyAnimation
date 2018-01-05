package com.ehighsun.myanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimDemo1 extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivImage;
    private Button btnStart,btnStop;
    private AnimationDrawable animationDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim_demo1);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStop = (Button) findViewById(R.id.btn_stop);
        ivImage = (ImageView) findViewById(R.id.iv_anim_image);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
//        setFrameAnim1();
//        setFrameAnim2();
        setFrameAnim3();//java代码
    }




    private void setFrameAnim1() {
        ivImage.setBackgroundResource(R.drawable.frame_anim1);
        animationDrawable = (AnimationDrawable) ivImage.getBackground();

    }

    private void setFrameAnim2() {
//        通过逐帧动画的资源文件获得AnimationDrawable示例
        animationDrawable = (AnimationDrawable) getResources().getDrawable(
                R.drawable.frame_anim1);
        ivImage.setBackground(animationDrawable);
    }


    private void setFrameAnim3() {
        animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.icon1),150);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.icon2),150);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.icon3),150);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.icon4),150);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.icon5),150);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.icon6),150);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.icon5),150);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.icon4),150);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.icon3),150);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.icon2),150);
        animationDrawable.setOneShot(false);
        ivImage.setBackground(animationDrawable);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                if(animationDrawable!=null && !animationDrawable.isRunning()){
                    animationDrawable.start();
                }
                break;
            case R.id.btn_stop:
                if(animationDrawable!=null && animationDrawable.isRunning()){
                    animationDrawable.stop();
                }
                break;
        }
    }
}
