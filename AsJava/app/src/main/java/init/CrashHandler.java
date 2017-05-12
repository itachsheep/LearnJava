package init;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.LogUtil;

/**
 * Created by taow on 2017/5/12.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String FILE_NAME = "crash";
    // log文件的后缀名
    private static final String FILE_NAME_SUFFIX = ".log";
    private Context mContext;
    private static CrashHandler sInstance = new CrashHandler();
    //系统默认的异常处理，默认情况下，系统会终止当前的异常程序
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    public static CrashHandler getInstance() {
        return sInstance;
    }

    public void init(Context context){
        mContext = context.getApplicationContext();
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        // 导出异常信息到SD卡中
        dumpExceptionToData(ex);
        // 这里可以通过网络上传异常信息到服务器，便于开发人员分析日志从而解决bug
//        uploadExceptionToServer();
    }

    private void dumpExceptionToData(Throwable ex){
        File dir = new File(getPath());
        if (!dir.exists()) {
            dir.mkdirs();
        }

        long current = System.currentTimeMillis();
        Date date=new Date(current);
        String contentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String titleTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
        // 以当前时间创建log文件
        File file = new File(getPath() + FILE_NAME + titleTime + FILE_NAME_SUFFIX);
        LogUtil.i("dumpExceptionToData file path: "+file.getAbsolutePath());
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            // 导出发生异常的时间
            pw.println(contentTime);

            // 导出手机信息
            dumpPhoneInfo(pw);

            pw.println();
            // 导出异常的调用栈信息
            ex.printStackTrace(pw);
            pw.flush();
        } catch (Exception e) {
            LogUtil.i("dump crash info failed");
        } finally {
            if (pw != null) {
                try {
                    pw.close();
                } catch (Exception e) {
                    LogUtil.i("close fail");
                }

            }
        }
    }

    private void dumpPhoneInfo(PrintWriter pw) throws PackageManager.NameNotFoundException {
        // 应用的版本名称和版本号
        PackageManager pm = mContext.getPackageManager();
        PackageInfo pi = pm.getPackageInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES);
        pw.print("App Version: ");
        pw.print(pi.versionName);
        pw.print('_');
        pw.println(pi.versionCode);

        // android版本号
        pw.print("OS Version: ");
        pw.print(Build.VERSION.RELEASE);
        pw.print("_");
        pw.println(Build.VERSION.SDK_INT);

        // 手机制造商
        pw.print("Vendor: ");
        pw.println(Build.MANUFACTURER);

        // 手机型号
        pw.print("Model: ");
        pw.println(Build.MODEL);

        // cpu架构
        pw.print("CPU ABI: ");
        pw.println(Build.CPU_ABI);
    }

    public String getPath(){
        String path =  Environment.getExternalStorageDirectory().getPath() + "/xin/" + mContext.getPackageName() + "/";
        LogUtil.i("getPath path: "+path);
//        boolean isMounted = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
//        LogUtil.i("getPath isMounte: "+isMounted);
//        String path = "/data/data/"+ mContext.getPackageName() + "/";
//        LogUtil.i("getPath path: "+path);
        return path;
    }
}
