package com.ehighsun.myanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FillingBetweenAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3,btn4,btn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filling_between_animation);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                startActivity(new Intent(this,TweenAnimAlpha.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this,TweenAnimScale.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this,TweenAnimTranslate.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(this,TweenAnimRotate.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(this,TweenAnimSet.class));
                break;
        }
    }
}
