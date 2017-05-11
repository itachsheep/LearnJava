package com.tao.asjava.activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.tao.asjava.R;

/**
 * Created by taow on 2017/4/10.
 */

public class KeyDownActivity extends Activity {
    private  int i = 0;
    private VideoView vv;
    private ProgressBar progressBar;
    private Button bt;
    private TextView timeIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keydown);
        progressBar = (ProgressBar) findViewById(R.id.keydown_pb);
        timeIndicator = (TextView) findViewById(R.id.keydown_tv);
//        vv = (VideoView) findViewById(R.id.keydown_vv);
//        vv.setVideoPath("http://hls.yun.gehua.net.cn:8088/live/CCTV2_2000.m3u8?delay=5&ET=1491992142403&TOKEN=8f0e01abcf30e8a3e6b089af31100e07");
//        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                vv.start();
//            }
//        });
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i("KeyDown","dispatchKeyEvent  i: "+i+", action: "+event.getAction()+ "，time:"+SystemClock.currentThreadTimeMillis());
        int keyCode = event.getKeyCode();
        if(keyCode == KeyEvent.KEYCODE_DPAD_RIGHT && event.getAction() == KeyEvent.ACTION_DOWN){
            Log.i("KeyDown","keycode right : "+event.getKeyCode()+", i: "+(i++)
                    +", action: "+event.getAction());

            progressBar.setProgress(i);
            setTimeIndicatorX(i);
            return true;
        }else if(keyCode == KeyEvent.KEYCODE_DPAD_LEFT && event.getAction() == KeyEvent.ACTION_DOWN){
            Log.i("KeyDown","keycode left : "+event.getKeyCode()+", i: "+(i--)
                    +", action: "+event.getAction());

            progressBar.setProgress(i);
            setTimeIndicatorX(i);
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    private void setTimeIndicatorX(int i){
        int pbLeft = progressBar.getLeft();
        int pbWidth = progressBar.getWidth();
        int progress = i;

        int thumbCenter = (int) (pbLeft + (float) pbWidth /100 * i + 0.5);
        int tvWidth = timeIndicator.getWidth();
        int tvX = thumbCenter - tvWidth / 2;
        timeIndicator.setX(tvX);
        timeIndicator.setText("21:0"+i);
    }

}
