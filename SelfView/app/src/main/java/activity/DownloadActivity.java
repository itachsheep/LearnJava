package activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import andorid.taow.selfview.R;

/**
 * Created by taow on 2017/6/5.
 */

public class DownloadActivity extends Activity {
    private Button btStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        btStart = (Button) findViewById(R.id.download_start);
    }
}
