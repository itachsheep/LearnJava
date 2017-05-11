package com.tao.asjava.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
