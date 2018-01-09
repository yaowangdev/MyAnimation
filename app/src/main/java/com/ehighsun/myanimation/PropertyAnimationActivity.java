package com.ehighsun.myanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PropertyAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3,btn4,btn5,btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        btn1 = (Button) findViewById(R.id.btn_case1);
        btn2 = (Button) findViewById(R.id.btn_case2);
        btn3 = (Button) findViewById(R.id.btn_case3);
        btn4 = (Button) findViewById(R.id.btn_case4);
        btn5 = (Button) findViewById(R.id.btn_case5);
        btn6 = (Button) findViewById(R.id.btn_case6);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_case1:
                startActivity(new Intent(this,PropertyCase1.class));
                break;
            case R.id.btn_case2:
                startActivity(new Intent(this,PropertyCase2.class));
                break;
            case R.id.btn_case3:
                startActivity(new Intent(this,PropertyCase3.class));
                break;
            case R.id.btn_case4:
                startActivity(new Intent(this,PropertyCase4.class));
                break;
            case R.id.btn_case5:

                break;
            case R.id.btn_case6:

                break;
        }
    }
}
