package com.tao.asjava.activity;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.EthernetManager;
import android.net.IpConfiguration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tao.asjava.R;

import util.LogUtil;

/**
 * Created by taow on 2017/4/26.
 */

public class EthernetActivity extends Activity {
    private Button bt;
    private TextView tv;
    private TextView tv2;
    private EthernetManager mEthManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ethernet);
        bt = (Button) findViewById(R.id.ethernet_bt);
        tv = (TextView) findViewById(R.id.ethernet_tv);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    String Mode = mEthManager.getEthernetMode();
//                    LogUtil.i("onCreate() Mode = " + Mode);
//
//                    DhcpInfo wifiInfo = mEthManager.getDhcpInfo();
//                    String ipAddress = intToIp(wifiInfo.ipAddress);
//                    String mask = intToIp(wifiInfo.netmask);
//                    String gateway = intToIp(wifiInfo.gateway);

//                    IpConfiguration ipConfiguration = mEthManager.getConfiguration(ConnectivityManager.TYPE_ETHERNET);
//                    LogUtil.i("ipconfiguration: "+ipConfiguration.toString());
                ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                cm.getActiveNetworkInfo();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    LogUtil.i("sleep exception e: "+e.getMessage());
                }
//                try{
//                    tv2.setText("dddd");
//                }catch (Exception e){
//                    LogUtil.i("exception e: "+e.getMessage());
//                }

            }
        });
    }

    private String intToIp(int paramInt) {
        return (paramInt & 0xFF) + "." + (0xFF & paramInt >> 8) + "." + (0xFF & paramInt >> 16) + "."
                + (0xFF & paramInt >> 24);
    }
}
