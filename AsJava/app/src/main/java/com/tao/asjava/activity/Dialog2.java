package com.tao.asjava.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.tao.asjava.R;

/**
 * Created by taow on 2017/3/25.
 */

public class Dialog2 extends Dialog {
    private String TAG = Dialog2.class.getSimpleName();
    private Activity mActivity;
    public Dialog2(Activity context) {
        super(context, R.style.CustomDialog);
        mActivity = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate ..");
        setContentView(R.layout.dialog_progressbar);
    }

//    private View onCreateView() {
//        LayoutInflater inflater = LayoutInflater.from(mActivity);
////        View view = inflater.inflate(R.layout.dialog_confirm, null);
//        return null;
//    }
}
