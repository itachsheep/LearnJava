package com.tao.asjava.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tao.asjava.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * AsJava
 * Created by tw on 2017/3/21.
 */

public class JsonArrayActivity extends Activity {
    private String TAG = JsonArrayActivity.class.getSimpleName();
    private Button bt ;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonarray);
        bt = (Button) findViewById(R.id.jsonarray_go);
        tv = (TextView) findViewById(R.id.jsonarray_info);

        bt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                String json = "[{\"volume\":\"100\"}]";
                String json2 = "";
                try {
                    JSONArray jsonArray = new JSONArray(json);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    String volume = jsonObject.getString("volume");
                    Log.i(TAG,"setOnKeyListener volume:"+volume);
                    tv.setText(volume);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return true;
            }
        });



    }
}
