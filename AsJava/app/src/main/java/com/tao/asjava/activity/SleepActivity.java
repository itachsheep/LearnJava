package com.tao.asjava.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import com.tao.asjava.R;

/**
 * Created by taow on 2017/4/12.
 */

public class SleepActivity extends Activity{
    Button btSleep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
        btSleep = (Button) findViewById(R.id.bt_sleep);
        btSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PowerManager pm = (PowerManager)getSystemService(POWER_SERVICE);



            }
        });
    }
}
