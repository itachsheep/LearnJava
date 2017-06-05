package com.tao.asjava.activity;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tao.asjava.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends Activity {
    private final String tag = MainActivity.class.getSimpleName();
    private TextView tvServer;
    private String serverXml;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0){
                tvServer.setText(serverXml);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btGet = (Button) findViewById(R.id.wget_bt_get);
        tvServer = (TextView) findViewById(R.id.wget_tv_server);

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String url = "http://172.28.254.121:8080/msis/getAdData?cardNumber=8000302100000341&sn=123456";
                //final String url = "http://10.180.88.71:8080/msis/getAdData?cardNumber=8000302100000341&sn=123456";

                tvServer.setText("");
                new Thread(){
                    @Override
                    public void run() {
                        serverXml = wGet(url);
                        mHandler.sendEmptyMessage(0);
                    }
                }.start();
            }
        });
    }
    public String wGet(String url) {

        String retData=getContent(url);
        Log.i(tag,"WGet retData: "+retData);
        return retData;

    }

    /**
     * 从某个接口取返回数据内容
     * @param url
     * @return
     */
    public String getContent(String url) {
        Log.i(tag,"getContent url: "+url);
        String content = null;
        int retry=3; // 重试次数
        for (int i = 0; i < retry; i++) {
            Log.i(tag,"getContent retry i: "+i);
            content = tryGetContent(url);
            if (content != null) {
                break;
            }
        }
        return content;
    }
    /**
     * 从某个接口取返回数据内容
     * @param url
     * @return
     */
    public String tryGetContent(String url) {
        Log.i(tag,"tryGetContent url : "+url);
        return fileGetContents(url);

    }


    /**
     * 从某个接口取返回数据内容
     * @param
     * @return
     */
    public  String fileGetContents(String strUrl) {
        Log.i(tag,"fileGetContents strUrl : "+strUrl);
        URL url1 = null;
        BufferedReader reader = null;
        HttpURLConnection connection = null;
        InputStreamReader ins = null;
        try {
            Log.i(tag,"fileGetContents try ");
            url1 = new URL(strUrl);
            connection = (HttpURLConnection) url1.openConnection();
            connection.setConnectTimeout(2 * 1000);
            connection.setReadTimeout(2 * 1000);
            connection.connect();
            Log.i(tag,"fileGetContents connection connect");
            ins = new InputStreamReader(connection.getInputStream());
            reader = new BufferedReader(ins);
            StringBuffer sb = new StringBuffer();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            Log.i(tag,"fileGetContents reader readLine");
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.i(tag,"fileGetContents MalformedURLException:"+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.i(tag,"fileGetContents IOException:"+e.getMessage());
        } finally {
            Log.i(tag,"fileGetContents finally");
            if (ins != null) {
                Log.i(tag,"fileGetContents finally ins not null");
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

}