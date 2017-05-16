package com.tao.asjava.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.tao.asjava.R;

import util.LogUtil;

/**
 * Created by taow on 2017/5/16.
 */

public class KeyVoiceActivity extends Activity implements View.OnClickListener {
    private Button btBaidu ;
    private Button btGehua ;
    private WebView mWebView;
    private EditText etBaidu;
    private EditText etGehua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyvoice);
        btBaidu = (Button) findViewById(R.id.keyvoice_bt1);
        btGehua = (Button) findViewById(R.id.keyvoice_bt2);
        etBaidu = (EditText) findViewById(R.id.keyvoice_et1);
        etGehua = (EditText) findViewById(R.id.keyvoice_et2);
        mWebView = (WebView)findViewById(R.id.keyvoice_wv);

        btBaidu.setOnClickListener(this);
        btGehua.setOnClickListener(this);

        btGehua.requestFocus();
    }

    @Override
    public void onClick(View v) {
        String url;
        switch (v.getId()){
            case R.id.keyvoice_bt1:
                url = etBaidu.getText().toString();
                LogUtil.i("baidu url: "+url);
                mWebView.clearCache(true);
                mWebView.loadUrl(url);
                break;
            case R.id.keyvoice_bt2:
                url = etGehua.getText().toString();
                LogUtil.i("gehua url: "+url);
                mWebView.clearCache(true);
                mWebView.loadUrl(url);
                break;
        }
    }
}
