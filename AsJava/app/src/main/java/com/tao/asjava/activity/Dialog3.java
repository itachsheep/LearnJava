package com.tao.asjava.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.tao.asjava.R;

import util.LogUtil;

/**
 * Created by taow on 2017/3/25.
 */

public class Dialog3 extends Dialog {
    private String TAG = Dialog3.class.getSimpleName();
    private Activity mActivity;
    private TextView dialog_tv;

    public Dialog3(Activity context) {
        super(context, R.style.CustomDialog);
        LogUtil.i("Dialog3.constructor..");
        mActivity = context;
    }

    @Override
    public void onAttachedToWindow() {
        LogUtil.i("Dialog3.onAttachedToWindow..");
        super.onAttachedToWindow();
    }

    @Override
    protected void onStart() {
        LogUtil.i("Dialog3.onStart..");
        super.onStart();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        LogUtil.i("Dialog3.onWindowFocusChanged..");
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i("Dialog3.onCreate..");
        Window window = getWindow();
//        window.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

        window.setContentView(R.layout.dialog_progressbar);
//        setContentView(R.layout.dialog_progressbar);

        int width = window.getWindowManager().getDefaultDisplay().getWidth();
        int height = window.getWindowManager().getDefaultDisplay().getHeight();
        window.setLayout(width/2,height/2);
        window.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);

        dialog_tv = (TextView) findViewById(R.id.dialog_tv);

    }
    public void setText(String mes){
        dialog_tv.setText(mes);
    }

    public void setLocatoin(){
        LogUtil.i("Dialog3.setLocatoin...");
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int width = window.getWindowManager().getDefaultDisplay().getWidth();
        int height = window.getWindowManager().getDefaultDisplay().getHeight();
        attributes.x = width/2;
        attributes.y = height/2;
        attributes.width = width/2;
        attributes.height = height/2;
        window.setAttributes(attributes);

    }

//    private View onCreateView() {
//        LayoutInflater inflater = LayoutInflater.from(mActivity);
////        View view = inflater.inflate(R.layout.dialog_confirm, null);
//        return null;
//    }
}
