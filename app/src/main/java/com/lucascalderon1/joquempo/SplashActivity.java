package com.lucascalderon1.joquempo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);




        initialWork();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_screen);
        img.setAnimation(anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                ActivityLogin();

            }
        }, 3000); // 3 segundos
    }

    private void initialWork() {
        img = findViewById(R.id.img_logo);
    }

    private void ActivityLogin() {
        Intent intent = new Intent(SplashActivity.this, RegrasActivity.class);
        startActivity(intent);



    }
}