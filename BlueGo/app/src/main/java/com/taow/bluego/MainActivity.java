package com.taow.bluego;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {


    private Button btSearch;
    private ListView lvDevice;
    private Button btOpen;
    private BluetoothManager bltoothManager;

    //蓝牙适配器，操作蓝牙的主要对象
    private BluetoothAdapter bltoothAdapter;
    private Context mContext;
    private ArrayList<BluetoothDevice> bltoothList = new ArrayList<BluetoothDevice>();

    public static final int MSG_BLUETOOTH_IN = 1;//设备已经接入
    public static final int MSG_BLUETOOTH_CONNECTED = 2;//设备连接上
    private BluetoothLvAdapter lvAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册监听蓝牙相关广播
        mContext = MainActivity.this;
        registerBroadcastReceiver();

        bltoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        bltoothAdapter = bltoothManager.getAdapter();

        setContentView(R.layout.fragment_bluetooth);
        initView();
        initData();
        initListener();
    }

    private void registerBroadcastReceiver(){
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_FOUND);//搜索蓝压设备，每搜到一个设备发送一条广播
        filter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);//配对开始时，配对成功时
        filter.addAction(BluetoothDevice.ACTION_PAIRING_REQUEST);//
        filter.addAction(BluetoothDevice.ACTION_PAIRING_CANCEL);//
        filter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED);//
        filter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);//
        filter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED);//

        //BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);//连接蓝牙，断开蓝牙,动作状态发生了变化
        filter.addAction(BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED);//
        filter.addAction(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);//
        filter.addAction(BluetoothAdapter.ACTION_REQUEST_ENABLE);//
        mContext.registerReceiver(bltoothReceiver,filter);
    }

    private BroadcastReceiver bltoothReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Bundle bundle = intent.getExtras();
            XLog.i("BluetoothFragment.onReceive action: "+action);
            Object[] lstName = bundle.keySet().toArray();
            for (int i = 0; i < lstName.length; i++){
                String keyName = lstName[i].toString();
                XLog.i("BluetoothFragment.onReceive key: "+ keyName +" >>> "+ String.valueOf(bundle.get(keyName)));
            }
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            // 搜索发现设备时，取得设备的信息；注意，这里有可能重复搜索同一设备
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                XLog.i("BluetoothFragment.onReceive Action_found");
                if(!bltoothList.contains(device)){
                    XLog.i("BluetoothFragment.onReceive Action_found add device");
                    bltoothList.add(device);
                    lvAdapter.notifyDataSetChanged();
                }
            }else if(BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)){
                int bondState = device.getBondState();
                XLog.i("BluetoothFragment.onReceive Action_bond_state_change bondState: "+bondState);
                lvAdapter.notifyDataSetChanged();
            }else if(BluetoothDevice.ACTION_PAIRING_REQUEST.equals(action)){
                Toast.makeText(mContext,"收到配对请求",Toast.LENGTH_SHORT).show();
            }
        }
    };


    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_BLUETOOTH_IN:
                    //设备已经接入
                    break;
                case MSG_BLUETOOTH_CONNECTED:
                    //设备已经连接
                    BluetoothDevice bd = (BluetoothDevice) msg.obj;
                    String name = bd.getName();
                    Toast.makeText(mContext,name+"--连接成功",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };



    private void initListener() {
        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"打开蓝牙",Toast.LENGTH_SHORT).show();
                bltoothAdapter.enable();
            }
        });
        btSearch.setOnClickListener(this);
        lvDevice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BluetoothDevice bd = bltoothList.get(i);

                int bondState = bd.getBondState();
                XLog.i("BluetoothFragment.onItemClick i: "+i+
                        ", name :"+bd.getName() +", bondState: "+bondState);
                if(bondState == BluetoothDevice.BOND_BONDED){
                    boolean res2 = BluManager.getInstance().removeBond(bd);
                    XLog.i("BluetoothFragment.onItemClick remove bond .. res2"+res2);
                }else if(bondState == BluetoothDevice.BOND_BONDING){

                }else if(bondState == BluetoothDevice.BOND_NONE){

                    boolean res = BluManager.getInstance().createBond(bd);
                    XLog.i("BluetoothFragment.onItemClick go to bond .. res: "+res);
                }



            }
        });
    }

    private void initData() {
        if(!isSupportedBlue()){
            return;
        }
        lvAdapter = new BluetoothLvAdapter(mContext,bltoothList);
        lvDevice.setAdapter(lvAdapter);
    }

    private void initView() {

        btSearch = (Button) findViewById(R.id.blue_bt_search);
        lvDevice = (ListView) findViewById(R.id.blue_lv_devicelist);
        btOpen = (Button) findViewById(R.id.blue_dsb_switch);

    }

    @Override
    public void onClick(View view) {
        startSearchBltDevice();
    }

    /**
     * 搜索蓝牙
     */
    private void startSearchBltDevice(){
        if (!isSupportedBlue()){
            XLog.i("BluetoothFragment.startSearchBltDevice not support");
            return;
        }
        clearBltoothList();
        /**
         * 如果当前发现了新的设备，则停止继续扫描，当前扫描到的新设备会通过广播推向新的逻辑
         */
        if(bltoothAdapter.isDiscovering()){
            stopSearchBltDevice();
        }
        bltoothAdapter.startDiscovery();
    }

    private void clearBltoothList(){
        bltoothList.clear();
        lvAdapter.notifyDataSetChanged();
    }

    private void stopSearchBltDevice(){
        bltoothAdapter.cancelDiscovery();
    }

    /**
     * 判断蓝牙是否打开
     * @return
     */
    private boolean isBlueOpen(){
        boolean isOpen = BluetoothAdapter.getDefaultAdapter().isEnabled();
        XLog.i("BluetoothFragment.isBlueOpen isOpen: "+isOpen);
        return isOpen;
    }

   /* private void openOrCloseBlue(){
        if(isBlueOpen()){
            XLog.i("BluetoothFragment.openOrCloseBlue disable");
            //关闭蓝牙
            BluetoothAdapter.getDefaultAdapter().disable();
        }else {
            XLog.i("BluetoothFragment.openOrCloseBlue enable");
            //打开蓝牙
//            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            mContext.startActivity(intent);
            BluetoothAdapter.getDefaultAdapter().enable();
        }
    }*/

    /**
     * 是否支持蓝牙
     * @return
     */
    private boolean isSupportedBlue(){
        BluetoothManager manager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        boolean res = manager != null ? true:false;
//        boolean res = BluetoothAdapter.getDefaultAdapter() != null ? true:false;
        XLog.i("BluetoothFragment.isSupportedBlue res: "+res);
        if(!res){
            Toast.makeText(mContext,"不支持蓝牙功能",Toast.LENGTH_SHORT).show();
        }
        return res;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisterReceiver();

    }

    /**
     * 反注册广播和清除蓝牙连接。在不需要使用蓝牙的时候调用
     */
    private void unRegisterReceiver(){
        XLog.i("BluetoothFragment.unRegisterReceiver");
        if(null != bltoothReceiver){
            XLog.i("BluetoothFragment.unRegisterReceiver success!");
            mContext.unregisterReceiver(bltoothReceiver);
            bltoothReceiver = null;
        }
        //取消蓝牙配对
        if(bltoothAdapter != null){
            bltoothAdapter.cancelDiscovery();
        }
    }


}
