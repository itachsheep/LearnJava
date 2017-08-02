package com.taow.bluego;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by taow on 2017/7/8.
 */

public class BluManager {
    private static BluManager bluManager;
    private BluetoothSocket rfcommSocketToServiceRecord;
    private BluManager(){
    }
    public static BluManager getInstance(){
        synchronized (new Object()){
            if(bluManager == null){
                bluManager = new BluManager();
            }
            return bluManager;
        }
    }

    /**
     *尝试连接一个设备，子线程中完成，因为会线程阻塞
     * @param bltoothDev
     * @param mHandler
     */
    public void connectDevice(final BluetoothDevice bltoothDev, final Handler mHandler){
        new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        XLog.i("BluManager.connectDevice");
                        rfcommSocketToServiceRecord = bltoothDev.createRfcommSocketToServiceRecord(Constant.SPP_UUID);
//                        rfcommSocketToServiceRecord = bltoothDev.
//                                createRfcommSocket(29);

                        if(rfcommSocketToServiceRecord != null){
                            //连接之前，停止搜索
                            if(BluetoothAdapter.getDefaultAdapter().isDiscovering()){
                                BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                            }

                            //如果当前 rfcommSocketToServiceRecord 已经处于连接状态，则不必连接
                            if(!rfcommSocketToServiceRecord.isConnected()){
                                XLog.i("BluManager.connectDevice connect start");

                                rfcommSocketToServiceRecord.connect();
                            }else {
                                XLog.i("BluManager.connectDevice connect already");
                            }

                            //连接成功
                            XLog.i("BluManager.connectDevice is Connected: "+rfcommSocketToServiceRecord.isConnected());
                            Message message = mHandler.obtainMessage();
//                            message.what = BluetoothFragment.MSG_BLUETOOTH_CONNECTED;
                            message.obj = bltoothDev;
                            mHandler.sendMessage(message);
                        }
                    } catch (IOException e) {
                        XLog.i("BluManager.connectDevice error " + e.getMessage());
                        e.printStackTrace();
                    }
            }
        }).start();

    }

    /**
     * 自动连接以往配对成功的设备。注意：连接的前提是服务器端已开启
     * 先配对，再连接
     * @param btDev
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public boolean createBond(BluetoothDevice btDev){

//        if (btDev.getBondState() == BluetoothDevice.BOND_NONE) {
//            //如果这个设备取消了配对，则尝试配对
//            XLog.i("BluManager.createBond create bond");
//            boolean bond = btDev.createBond();
//            XLog.i("BluManager.createBond create bond: "+bond);
//            return bond;
//        }

        XLog.i("BluManager.createBond state: "+btDev.getBondState());
        boolean bond = btDev.createBond();
        XLog.i("BluManager.createBond create bond: "+bond);
        return bond;
    }

    public boolean removeBond(BluetoothDevice btDev){
        XLog.i("BluManager.removeBond  ");
        boolean res = btDev.removeBond();
        XLog.i("BluManager.removeBond res: "+res);
        return res;
    }

    /**
     * 获得系统保存的配对成功过的设备，并尝试连接
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void autoConnectAllDeviceRecorded() {
        XLog.i("BluManager.autoConnectAllDeviceRecorded by mac addr");
        //获得已配对的远程蓝牙设备的集合
        Set<BluetoothDevice> devices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
        XLog.i("BluManager.autoConnectAllDeviceRecorded device size: "+devices.size());
        if (devices.size() > 0) {
            for (Iterator<BluetoothDevice> it = devices.iterator(); it.hasNext(); ) {
                BluetoothDevice device = it.next();
                //自动连接已有蓝牙设备
                createBond(device);
            }
        }
    }

    /**
     * 输入mac地址进行自动配对
     * 前提是系统保存了该地址的对象
     *
     * @param address
     */
    public void autoConnectByMacAddr(String address, Handler handler) {

        XLog.i("BluManager.autoConnectByMacAdd");
        if (BluetoothAdapter.getDefaultAdapter().isDiscovering()){
            BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
        }
        BluetoothDevice btDev = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(address);
        XLog.i("BluManager.autoConnectByMacAdd btDev name: "+btDev.getName());
        connectDevice(btDev, handler);
    }

    /**
     * 是否支持蓝牙
     * @return
     */
    private boolean isSupportedBlue(){
        boolean res = BluetoothAdapter.getDefaultAdapter() != null ? true:false;
        return res;
    }

    public void disConnect(){
        XLog.i("BluManager.disConnect");
        try {
            rfcommSocketToServiceRecord.close();
        } catch (IOException e) {
            XLog.i("BluManager.disConnect "+e.getMessage());
            e.printStackTrace();
        }
    }
}
