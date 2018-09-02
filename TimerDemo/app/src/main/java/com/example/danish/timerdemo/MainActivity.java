package com.example.danish.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //New way to do timers
        new CountDownTimer(10000, 1000) {
            public void onTick(long millisecondsUntilDone) {
                //countdown is counting down (Every second)
                Log.i("Seconds left ", String.valueOf(millisecondsUntilDone / 1000));
            }

            public void onFinish() {
                // Counter is finished! (After 10 seconds)
                Log.i("Done", "Countdown timer Finished");
            }
        }.start();

    }
            /*
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                //Insert code to be run every second
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(run);
       */
}

