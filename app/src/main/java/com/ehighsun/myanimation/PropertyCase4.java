package com.ehighsun.myanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

public class PropertyCase4 extends AppCompatActivity {
    private TextView tvHello;
    private ViewPropertyAnimator animate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_case4);
        tvHello = (TextView) findViewById(R.id.tv_Hello);
        startAnimation();
    }

    private void startAnimation() {
        animate = tvHello.animate();
        animate
                .alpha(0.2f)
                .rotation(360f)
                .setInterpolator(new AccelerateInterpolator())
                .translationX(100f)
                .scaleX(2f)
                .scaleY(2f)
                .setDuration(3000);
    }
}
