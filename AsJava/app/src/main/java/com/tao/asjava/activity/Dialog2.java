package com.tao.asjava.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.tao.asjava.R;

import util.LogUtil;

/**
 * Created by taow on 2017/3/25.
 */

public class Dialog2 extends Dialog {
    private String TAG = Dialog2.class.getSimpleName();
    private Activity mActivity;
    private TextView dialog_tv;

    public Dialog2(Activity context) {
        super(context, R.style.CustomDialog);
        LogUtil.i("Dialog2.constructor..");
        mActivity = context;
    }

    @Override
    public void onAttachedToWindow() {
        LogUtil.i("Dialog2.onAttachedToWindow..");
        super.onAttachedToWindow();
    }

    @Override
    protected void onStart() {
        LogUtil.i("Dialog2.onStart..");
        super.onStart();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        LogUtil.i("Dialog2.onWindowFocusChanged..");
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public Bundle onSaveInstanceState() {
        LogUtil.i("Dialog2.onSaveInstanceState..");
        return super.onSaveInstanceState();
    }

    @Override
    public void onActionModeFinished(ActionMode mode) {
        LogUtil.i("Dialog2.onActionModeFinished..");
        super.onActionModeFinished(mode);
    }

    @Override
    public void onActionModeStarted(ActionMode mode) {
        LogUtil.i("Dialog2.onActionModeStarted..");
        super.onActionModeStarted(mode);
    }

    @Override
    public void onContentChanged() {
        LogUtil.i("Dialog2.onContentChanged..");
        super.onContentChanged();
    }

    @Override
    public void onDetachedFromWindow() {
        LogUtil.i("Dialog2.onDetachedFromWindow..");
        super.onDetachedFromWindow();
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        LogUtil.i("Dialog2.onPanelClosed..");
        super.onPanelClosed(featureId, menu);
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        LogUtil.i("Dialog2.onWindowAttributesChanged..");
        super.onWindowAttributesChanged(params);
    }

    @Override
    protected void onStop() {
        LogUtil.i("Dialog2.onStop..");
        super.onStop();
    }

    @Override
    public View onCreatePanelView(int featureId) {
        LogUtil.i("Dialog2.onCreatePanelView..");
        return super.onCreatePanelView(featureId);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        LogUtil.i("Dialog2.onTrackballEvent..");
        return super.onTrackballEvent(event);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        LogUtil.i("Dialog2.onCreateContextMenu..");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        LogUtil.i("Dialog2.onPreparePanel..");
        return super.onPreparePanel(featureId, view, menu);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        LogUtil.i("Dialog2.onRestoreInstanceState..");
        super.onRestoreInstanceState(savedInstanceState);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i("Dialog2.onCreate..");
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
        LogUtil.i("Dialog2.setLocatoin...");
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
