package andorid.taow.adtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;

import com.inspur.cyberbackdemo.view.QINWebView;
import com.inspur.qin.QinPlayer;
import com.inspur.qinporting.QINPlayer;
import com.xin.util.XLog;

public class MainActivity extends Activity {
    private QINWebView mWebView;
    private Handler mHandler = new Handler();
    private QINPlayer mPlayer;
    private int handlerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QINPlayer.setHandler(mHandler);
        //mWebView = (QINWebView) findViewById(R.id.load_web);
        //mPlayer = mWebView.getPlayer();
        mPlayer = new QINPlayer(MainActivity.this);

        handlerId = mPlayer.create(null);
        String json = "{\"type\":\"dvbc\",\"url\":[{\"frequency\":546000,\"symbolRate\":6875,\"modulation\":\"qam64\",\"polarization\":\"\",\"serviceId\":188,\"tsId\":44,\"videoPID\":6273,\"videoDecodeType\":2,\"audioPID\":6274,\"audioDecodeType\":4,\"pcrPID\":6273,\"programType\":1}]}";
        mPlayer.start(handlerId, json);
        XLog.i("[Main.startPlay] end handlerId:" + handlerId);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        XLog.i("[Main.dispatchKeyEvent] key down ..111");
        if(event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            XLog.i("[Main.dispatchKeyEvent] key down ..");
            mPlayer.pause(handlerId);
            MainActivity.this.finish();
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

}
