package com.tao.asjava.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.tao.asjava.R;

/**
 * AsJava
 * Created by tw on 2017/3/13.
 */

public class EvaluateActivity extends Activity {
    private WebView wv;
    private Context mContext;
    private String TAG = EvaluateActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        Button btGo = (Button) findViewById(R.id.ev_go);
        wv = (WebView) findViewById(R.id.ev_WV);
        mContext = EvaluateActivity.this;
        //设置编码
        wv.getSettings().setDefaultTextEncodingName("utf-8");
        //支持js
        wv.getSettings().setJavaScriptEnabled(true);
        //设置背景颜色 透明
        wv.setBackgroundColor(Color.argb(0, 0, 0, 0));
        //设置本地调用对象及其接口
        wv.addJavascriptInterface(new JavaScriptObject(), "myObj");
        //载入js
        wv.loadUrl("file:///android_asset/index.html");


        btGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"button on clicked......");
                wv.evaluateJavascript("sum(1,2)", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        Log.i(TAG,"evaluateJavascript sum:"+value);
                        Toast.makeText(mContext, "evaluateJavascript sum:"+value,
                                Toast.LENGTH_LONG).show();
                    }
                });
//                wv.loadUrl("javascript:funFromjs()");
//                Toast.makeText(mContext, "调用javascript:funFromjs()", Toast.LENGTH_LONG).show();
            }
        });
    }


}
