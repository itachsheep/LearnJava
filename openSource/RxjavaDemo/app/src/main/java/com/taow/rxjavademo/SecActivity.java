package com.taow.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import util.LogUtils;

public class SecActivity extends AppCompatActivity {
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.sec_bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //1, 使用Rxjava observer
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                LogUtils.i("Observer onSubscribe ");
            }

            @Override
            public void onNext(@NonNull String s) {
                LogUtils.i("Observer onNext ");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LogUtils.i("Observer onError ");
            }

            @Override
            public void onComplete() {
                LogUtils.i("Observer onComplete ");
            }
        };

        //2，使用Rxjava subscribe

        //3, 创建Observable
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                LogUtils.i("Observable subscribe ");
                e.onNext("Hello");
                e.onNext("Hi");
                e.onNext("aloha");
                e.onComplete();
            }
        });

    }
}
