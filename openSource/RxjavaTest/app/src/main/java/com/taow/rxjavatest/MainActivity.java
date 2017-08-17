package com.taow.rxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import rx.Observer;
import util.LogUtils;
import util.RxjavaManager;


public class MainActivity extends AppCompatActivity {
    private Button bt;
    Observer<String> observer = new Observer<String>() {


        @Override
        public void onCompleted() {
            LogUtils.i("onCompleted ..");
        }

        @Override
        public void onError(Throwable e) {
            LogUtils.i("onError e: "+e.getMessage());
        }

        @Override
        public void onNext(String s) {
            LogUtils.i("onNext s: "+s);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.main_bt);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RxjavaManager.getObservable().subscribe(observer);
            }
        });
    }

}
