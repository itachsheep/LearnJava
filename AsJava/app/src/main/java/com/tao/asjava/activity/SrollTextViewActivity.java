package com.tao.asjava.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tao.asjava.R;

/**
 * Created by taow on 2017/4/24.
 */

public class SrollTextViewActivity extends Activity {
    private TextView scrollTv;
    private TextView scrollTv2;
    private Button scrollBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srolltextview);
        scrollTv = (TextView) findViewById(R.id.scroll_tv);
        scrollTv2 = (TextView) findViewById(R.id.scroll_tv2);
        scrollBt = (Button) findViewById(R.id.scroll_bt);
        scrollBt.requestFocus();

        scrollTv.setText("的时刻记得了封建时代了开发商的理发师可怜见离开世界" +
                "东方控江路事件多发离开家的上了飞塑" +
                "料袋放进塑料袋圣诞节法律上的交流反士大夫昆仑山觉得馈机");

        scrollTv2.setText("的时刻记得了封建时代了开发商的理发师可怜见离开世界" +
                "东方控江路事件多发离开家的上了飞塑" +
                "料袋放进塑料袋圣诞节法律上的交流反士大夫昆仑山觉得馈机");
        scrollTv2.setVisibility(View.VISIBLE);
    }
}
