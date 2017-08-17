package util;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by taowei on 2017/8/17.
 * 2017-08-17 22:44
 * RxjavaTest
 * util
 */

public class RxjavaManager {

    private static Observable<String> observable;
    public static Observable<String> getObservable(){
        synchronized (RxjavaManager.class) {
            if (null == observable) {
                observable = Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("Hello");
                        subscriber.onNext("Hi");
                        subscriber.onNext("Aloha");
                        subscriber.onCompleted();
                    }
                });
                return observable;
            } else {
                return observable;
            }
        }
    }
}
