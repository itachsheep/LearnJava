package com.tao.asjava.activity;

import android.app.Activity;
import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tao.asjava.R;

public class DnsActivity extends Activity {
    private final String tag = DnsActivity.class.getSimpleName();
    private TextView dnsInfo;
    private WifiManager wifiManager;
//    private EthernetManager ethernetManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dns);

        Button btDns = (Button) findViewById(R.id.dns_go);
        dnsInfo = (TextView) findViewById(R.id.dns_info);

        btDns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void getWifiDnsInfo() {
        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
        StringBuilder sb = new StringBuilder();
        sb.append("网络信息：");
        sb.append("\nipAddress：" + intToIp(dhcpInfo.ipAddress));
        sb.append("\nnetmask：" + intToIp(dhcpInfo.netmask));
        sb.append("\ngateway：" + intToIp(dhcpInfo.gateway));
        sb.append("\nserverAddress：" + intToIp(dhcpInfo.serverAddress));
        sb.append("\ndns1：" + intToIp(dhcpInfo.dns1));
        sb.append("\ndns2：" + intToIp(dhcpInfo.dns2));
        sb.append("\n");
        dnsInfo.setText(sb.toString());
        Log.i(tag, intToIp(dhcpInfo.ipAddress));
        Log.i(tag, intToIp(dhcpInfo.netmask));
        Log.i(tag, intToIp(dhcpInfo.gateway));
        Log.i(tag, intToIp(dhcpInfo.serverAddress));
        Log.i(tag, intToIp(dhcpInfo.dns1));
        Log.i(tag, intToIp(dhcpInfo.dns2));
        Log.i(tag, "" + dhcpInfo.leaseDuration);
    }

    private String intToIp(int paramInt) {
        return (paramInt & 0xFF) + "." + (0xFF & paramInt >> 8) + "." + (0xFF & paramInt >> 16) + "."
                + (0xFF & paramInt >> 24);
    }


}

