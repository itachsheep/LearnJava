package com.taow.bluego;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by taow on 2017/7/27.
 */

public class BluetoothLvAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<BluetoothDevice> mList;
    public BluetoothLvAdapter(Context ctx, ArrayList<BluetoothDevice> list){
        mContext = ctx;
        mList = list;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return mList == null ? 0:mList.size();
    }

    @Override
    public Object getItem(int i) {

        return mList == null ? null: mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = inflater.inflate(R.layout.bluth_list_item,null);
            holder = new ViewHolder();
            holder.blthName = (TextView) view.findViewById(R.id.blth_item_name);
            holder.blthState = (TextView) view.findViewById(R.id.blth_item_state);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        BluetoothDevice bluetoothDevice = mList.get(i);

        String name = bluetoothDevice.getName();
        XLog.i("BluetoothLvAdapter.getView name: "+name);
        if(TextUtils.isEmpty(name)){
            holder.blthName.setText("未知");
        }else {
            holder.blthName.setText(name);
        }

        if(isConnected(bluetoothDevice)){
            XLog.i("BluetoothLvAdapter.getView connected");
            holder.blthState.setText("已连接");
        }else {
            XLog.i("BluetoothLvAdapter.getView pair..");
            holder.blthState.setText(getBondState(bluetoothDevice.getBondState()));
        }

        return view;
    }

    private String getBondState(int bondState) {
        String result = "";
        switch (bondState) {
            case BluetoothDevice.BOND_BONDING://正在配对
                result =  "正在配对";
                break;
            case BluetoothDevice.BOND_BONDED://配对结束
                result =  "完成配对";
                break;
            case BluetoothDevice.BOND_NONE://取消配对/未配对
                result =  "未配对";
                break;
            default:
                break;
        }
        XLog.i("BluetoothLvAdapter.getBondState result: "+result+", bondState: "+bondState);
        return result;
    }

    private boolean isConnected(BluetoothDevice bltoothDev){
        boolean isConnected = false;
        BluetoothSocket rfcommSocketToServiceRecord = null;
        XLog.i("BluetoothLvAdapter.isConnected...");
        try {
            rfcommSocketToServiceRecord = bltoothDev.createRfcommSocketToServiceRecord(Constant.SPP_UUID);
            if(rfcommSocketToServiceRecord != null){
                isConnected = rfcommSocketToServiceRecord.isConnected();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        XLog.i("BluetoothLvAdapter.isConnected : "+isConnected);
        return isConnected;
//        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
//        int a2dp  = defaultAdapter.getProfileConnectionState(BluetoothProfile.A2DP);//可操控蓝牙设备，如带播放暂停功能的蓝牙耳机
//        int headset = defaultAdapter.getProfileConnectionState(BluetoothProfile.HEADSET);//蓝牙头戴式耳机，支持语音输入输出
//        int health = defaultAdapter.getProfileConnectionState(BluetoothProfile.HEALTH);//蓝牙穿戴式设备
//        int flag = -1;
//        if (a2dp == BluetoothProfile.STATE_CONNECTED) {
//            flag = a2dp;
//        } else if (headset == BluetoothProfile.STATE_CONNECTED) {
//            flag = headset;
//        } else if (health == BluetoothProfile.STATE_CONNECTED) {
//            flag = health;
//        }
    }

    public class ViewHolder {
        private TextView blthName;
        private TextView blthState;

    }
}
