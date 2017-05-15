package com.tao.asjava.activity;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.EthernetManager;
import android.net.IpConfiguration;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.RouteInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tao.asjava.R;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;

import util.LogUtil;

/**
 * Created by taow on 2017/4/26.
 */

public class EthernetActivity extends Activity {
    private Button bt;
    private TextView tv;
    private TextView tv2;
    private EthernetManager mEthManager;


    private InetAddress mIpAddress;
    private InetAddress mGatewayAddress;
    private InetAddress mDnsAddress;
    private String mInterfaceName;
    private String mNetworkMask;
    private int mMaskPrefix = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ethernet);
        bt = (Button) findViewById(R.id.ethernet_bt);
        tv = (TextView) findViewById(R.id.ethernet_tv);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                LinkProperties activeLinkProperties = cm.getActiveLinkProperties();
                // ip
                List<InetAddress> ipAddresses = activeLinkProperties.getAddresses();
                mIpAddress = ipAddresses.get(0);
                LogUtil.i("ip: "+formatAddress(mIpAddress));
                // dns
                List<InetAddress> dnsServers = activeLinkProperties.getDnsServers();
                mDnsAddress = dnsServers.get(0);
                LogUtil.i("dns: "+formatAddress(mDnsAddress));

                // gateway
                List<RouteInfo> routes = activeLinkProperties.getRoutes();
                for (RouteInfo rinfo:
                     routes) {
                    if(rinfo.isDefaultRoute()){
                        mGatewayAddress = rinfo.getGateway();
                        LogUtil.i("gateway: "+ formatAddress(mGatewayAddress));
                    }
                }
                // mask
                List<LinkAddress> linkAddresses = activeLinkProperties.getLinkAddresses();
                for (LinkAddress linkAddr:
                     linkAddresses) {
                    mMaskPrefix = linkAddr.getNetworkPrefixLength();
                    LogUtil.i("mask length: "+mMaskPrefix);
                }
                mNetworkMask = formatAddress(formatMaskPrefix(mMaskPrefix));
                LogUtil.i("mNetworkMask : "+mNetworkMask);

                //intercace name
                mInterfaceName = activeLinkProperties.getInterfaceName();
                LogUtil.i("interface name: "+mInterfaceName);
            }
        });
    }

    public static byte[] formatMaskPrefix(int maskPrefix) {
        byte[] array = new byte[4];
        int temp = maskPrefix;
        for (int i = 0; i < 4; i++) {
            if (temp > 8) {
                array[i] = (byte) 255;
            } else if (temp > 0) {
                array[i] = (byte) ~((1 << (8 - temp)) - 1);
            } else {
                array[i] = 0;
            }
            temp = temp - 8;
        }
        return array;
    }

    public String formatAddress(InetAddress addr) {
        byte[] address = addr.getAddress();
        String ip = Integer.toString(0xff & address[0])+"."+
                Integer.toString(0xff & address[1])+"."+
                Integer.toString(0xff & address[2])+"."+
                Integer.toString(0xff & address[3]);
        return ip;
    }

    public String formatAddress(byte[] address) {

        String ip = Integer.toString(0xff & address[0])+"."+
                Integer.toString(0xff & address[1])+"."+
                Integer.toString(0xff & address[2])+"."+
                Integer.toString(0xff & address[3]);
        return ip;
    }
}
