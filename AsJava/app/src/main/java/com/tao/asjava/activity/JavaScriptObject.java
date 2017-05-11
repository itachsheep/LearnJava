package com.tao.asjava.activity;

import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * AsJava
 * Created by tw on 2017/3/13.
 */

public class JavaScriptObject {
@JavascriptInterface
public void fun1FromAndroid(String mes) {
    Log.i("EvaluateActivity","back is called ....mes:"+mes);
}
}
