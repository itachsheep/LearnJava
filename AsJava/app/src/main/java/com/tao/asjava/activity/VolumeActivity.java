package com.tao.asjava.activity;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tao.asjava.R;

/**
 * AsJava
 * Created by tw on 2017/3/22.
 */

public class VolumeActivity extends Activity implements View.OnClickListener {
    private Button btAdd;
    private Button btSub;
    private AudioManager mAudioManager;
    private TextView tvCur;
    private int maxVol;
    private int minVol;
    private String TAG = VolumeActivity.class.getSimpleName();
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.test_for);

        btAdd = (Button) findViewById(R.id.volume_bt_add);
        btSub = (Button) findViewById(R.id.volume_bt_sub);
        tvCur = (TextView) findViewById(R.id.volume_tv);
//        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//        maxVol = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
//        Log.i(TAG,"VolumeActivity.onCreate  maxVol: "+maxVol);

        setListener();
    }

    private void setListener() {
//        btAdd.setOnClickListener(this);
//        btSub.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.volume_bt_add:
                int currentVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                currentVolume += 1;

                Log.i(TAG,"onclick add currentVolume: "+currentVolume);
                if(currentVolume > maxVol){
                    currentVolume = maxVol;
                }
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC,currentVolume,0);
                tvCur.setText("当前音量："+currentVolume+", 最大音量："+maxVol);
                break;
            case R.id.volume_bt_sub:
                int curVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                curVolume -= 1;
                Log.i(TAG,"onclick sub curVolume: "+curVolume);
                if(curVolume < 0){
                    curVolume = 0;
                }
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC,curVolume,0);
                tvCur.setText("当前音量："+curVolume+", 最大音量："+maxVol);
                break;
            default:
                break;
        }
    }
}
