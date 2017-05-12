package init;

import android.app.Application;

import util.LogUtil;

/**
 * Created by taow on 2017/5/12.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.i("MyApplication onCreate..");
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
//        crashHandler.getPath();
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
    }
}
