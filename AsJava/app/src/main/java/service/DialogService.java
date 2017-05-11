package service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import android.util.Log;

import com.tao.asjava.R;
import com.tao.asjava.activity.DialogActivity;

import view.CaTipsDialog;

/**
 * AsJava
 * Created by tw on 2017/3/23.
 */

public class DialogService extends Service {

    private CaTipsDialog caTips;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("CaTipsDialog"," DialogService.. onCreate..");
        caTips = new CaTipsDialog(DialogService.this);
        caTips.show(R.string.ca_cha_ru,true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("CaTipsDialog"," DialogService.. onStartCommand..");
        return super.onStartCommand(intent, flags, startId);
    }
}
