package service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;

import andorid.taow.selfview.IDownload;
import andorid.taow.selfview.IDownloadCallback;
import util.LogUtil;

/**
 * Created by taow on 2017/6/5.
 */

public class DownloadService extends Service {
    private IDownloadCallback downloadCallback;
    private DownloadBinder downloadBinder = new DownloadBinder();
    private Handler mHandler = new Handler();
    @Override
    public void onCreate() {
        LogUtil.i("DownloadService.onCreate");
        super.onCreate();
        sendDownloadProgress();
    }
    private Thread downloadThread;
    private int progress = 0;
    private Runnable progressRunnable = new Runnable() {
        @Override
        public void run() {
            if(null != downloadBinder){
                LogUtil.i("DownloadService.progressRunnable progress: "+progress);
                progress++;
                downloadBinder.sendDownloadState(0,progress);
            }
            mHandler.postDelayed(progressRunnable,1500);
        }
    };
    private void sendDownloadProgress() {
        progress = 0;
        LogUtil.i("DownloadService.sendDownloadProgress");
        downloadThread = new Thread(){
            @Override
            public void run() {
                mHandler.postDelayed(progressRunnable,1500);
            }
        };
        downloadThread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.i("DownloadService.onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.i("DownloadService.onBind..");
        return downloadBinder;
    }

    @Override
    public void onDestroy() {
        LogUtil.i("DownloadService.onDestroy");
        super.onDestroy();
        if(mHandler != null){
            mHandler.removeCallbacks(progressRunnable);
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtil.i("DownloadService.onUnbind");
        if(mHandler != null){
            mHandler.removeCallbacks(progressRunnable);
        }
        return super.onUnbind(intent);
    }

    public class DownloadBinder extends IDownload.Stub{

        @Override
        public int getIpState() throws RemoteException {
            return 0;
        }

        @Override
        public void setIpUpgradeCallback(IDownloadCallback listener) throws RemoteException {
            LogUtil.i("DownloadServiceset.DownloadBinder.setIpUpgradeCallback ");
            downloadCallback = listener;
        }

        @Override
        public void operateIpService(int opCode) throws RemoteException {
            LogUtil.i("DownloadServiceset.DownloadBinder.operateIpService ");
        }

        private void sendDownloadState(int state, int progress){
            LogUtil.i("DownloadServiceset.DownloadBinder.sendDownloadState state: "+state+", progress: "+progress);
            if(null != downloadCallback){
                try {
                    downloadCallback.onResult(state,progress);
                } catch (RemoteException e) {
                    LogUtil.i("DownloadServiceset.DownloadBinder.sendDownloadState exception...... ");
                    e.printStackTrace();
                }
            }else {
                LogUtil.i("DownloadServiceset.DownloadBinder.sendDownloadState callback null... ");
            }
        }
    }
}
