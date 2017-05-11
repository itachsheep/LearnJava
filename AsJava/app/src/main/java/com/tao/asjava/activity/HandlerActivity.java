package com.tao.asjava.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.tao.asjava.R;

import java.lang.ref.WeakReference;

/**
 * AsJava
 * Created by tw on 2017/3/15.
 */

public class HandlerActivity extends Activity {
    private ImageView imageView;
    private Handler mhandler;
    private String TAG = HandlerActivity.class.getSimpleName();
    private class LocalHandler extends Handler{
        private final WeakReference<HandlerActivity> activityRef;
        public LocalHandler(HandlerActivity activity){
            activityRef = new WeakReference<HandlerActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            if(null != activityRef){
                Log.i(TAG,"LocalHandler activityRef is ok");
                HandlerActivity activity = activityRef.get();
                activity.handleMessage(msg);
            }else {
                Log.i(TAG,"LocalHandler activityRef is null");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        Button btShow = (Button) findViewById(R.id.handle_bt_show);
        Button btHide = (Button) findViewById(R.id.handle_bt_hide);
        imageView = (ImageView) findViewById(R.id.handle_iv);
        mhandler = new LocalHandler(this);


        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"onClick ..");
                showPF();
            }
        });

    }

    private void showPF() {
        Log.i(TAG,"showPF ..");
        imageView.setVisibility(View.VISIBLE);
        resetHideViewTimer();
    }

    public void handleMessage(Message msg){
        Log.i(TAG,"handleMessage msg: "+msg.what);
    }

    Runnable clearRunnable = new Runnable() {
        @Override
        public void run() {
            Log.i(TAG,"clearRunnable ..");
            imageView.setVisibility(View.INVISIBLE);
        }
    };

    private void resetHideViewTimer() {
        Log.i(TAG, "resetHideViewTimer ");
        if (null != mhandler) {
            Log.i(TAG, "resetHideViewTimer ok");
            mhandler.removeCallbacks(clearRunnable);
            mhandler.postDelayed(clearRunnable, 5 * 1000);
        }
    }
}
