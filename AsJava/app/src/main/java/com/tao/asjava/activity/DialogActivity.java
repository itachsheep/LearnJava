package com.tao.asjava.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tao.asjava.R;

import service.DialogService;
import view.CaTipsDialog;

/**
 * AsJava
 * Created by tw on 2017/3/23.
 */

public class DialogActivity extends Activity {
    private Intent service;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    showAnotherDialog();
                    break;
            }
        }
    };

    private void showAnotherDialog() {
        Dialog3 dialog = new Dialog3(DialogActivity.this);
        dialog.setLocatoin();
        dialog.show();
        dialog.setText("第二个dialog");
    }

    //test for me
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
//        service = new Intent(DialogActivity.this,DialogService.class);
        Button show = (Button) findViewById(R.id.dialog_show);


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.i("CaTipsDialog"," DialogActivity.. setOnClickListener..");
//                startService(service);
                Dialog2 dialog = new Dialog2(DialogActivity.this);
                dialog.show();
                dialog.setText("第一个dialog");

                mHandler.sendEmptyMessageDelayed(1,1500);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
//        stopService(service);
    }

    @Override
    public void finish() {
        super.finish();
//        stopService(service);
    }
}
