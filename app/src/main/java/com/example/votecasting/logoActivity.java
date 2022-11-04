package com.example.votecasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class logoActivity extends AppCompatActivity {

    Animation topAnim;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_logo);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        img = (ImageView)findViewById(R.id.imageView3);
//Set animation to elements
        img.setAnimation(topAnim);


        logoActivity.LogoLauncher logoLauncher = new logoActivity.LogoLauncher();
        logoLauncher.start();

    }

    private class LogoLauncher extends Thread {
        public void run()
        {
            try
            {
                sleep(4000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(logoActivity.this,FlashActivity.class);
            startActivity(intent);
            logoActivity.this.finish();
        }
    }
}


