package com.tao.asjava.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.tao.asjava.R;

import view.ResetDialogFragment;

/**
 * AsJava
 * Created by tw on 2017/3/22.
 */

public class ProgressActivity extends Activity {
    private  FrameLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);
        Button bt = (Button) findViewById(R.id.progressbar_bt_reset);
        layout = (FrameLayout) findViewById(R.id.progressbar_fl);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Dialog dialog = new Dialog(ProgressActivity.this);
//                dialog.setContentView(R.layout.dialog_progressbar);
//                dialog.show();
                ResetDialogFragment dialogFragment = new ResetDialogFragment();
                dialogFragment.show(ProgressActivity.this.getFragmentManager(),
                        ProgressActivity.class.getSimpleName());
            }
        });
    }
}
