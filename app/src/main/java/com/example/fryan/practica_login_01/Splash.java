package com.example.fryan.practica_login_01;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

                progressBar = findViewById(R.id.splash_progress_id);
               final Intent intent = new Intent(Splash.this, MainActivity.class);


        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 300) {
                    progressStatus += 1;

                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                    try {
                        Thread.sleep(4000);
                        startActivity(intent);
                        finish();
                        Thread.interrupted();
                        return;
                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }
                }
            }
        }).start();

    }
}




