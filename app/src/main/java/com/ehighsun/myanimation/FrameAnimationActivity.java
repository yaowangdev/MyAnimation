package com.ehighsun.myanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrameAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        btn1= (Button) findViewById(R.id.btn_frame_anim1);
        btn2= (Button) findViewById(R.id.btn_frame_anim2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_frame_anim1:
                startActivity(new Intent(this,FrameAnimDemo1.class));
                break;
            case R.id.btn_frame_anim2:
                break;
        }
    }
}
