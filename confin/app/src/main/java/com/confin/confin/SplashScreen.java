package com.confin.confin;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import static java.lang.Thread.sleep;

public class SplashScreen extends Activity {

    protected static final int TIMER_RUNTIME = 3000;
    protected  boolean mbActive;
    protected ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        final Thread timerThread = new Thread(){
            @Override
            public void run(){
                mbActive = true;
                try {
                    int waited = 0;
                    while (mbActive && (waited < TIMER_RUNTIME)){
                        sleep(200);;
                        if (mbActive){
                            waited += 200;
                            updateProgress(waited);
                        }
                    }
                    startActivity( new Intent(SplashScreen.this, Login.class));
                    finish();
                }catch (InterruptedException e){
//                    em caso de erro
                }
            }
        };
        timerThread.start();
    }

    public void updateProgress(final int timePassed){
        if (null != progressBar){
            final int progress = progressBar.getMax() * timePassed / TIMER_RUNTIME;
            progressBar.setProgress(progress);
        }
    }
}
