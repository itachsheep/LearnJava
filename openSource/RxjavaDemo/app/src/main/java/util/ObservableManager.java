package util;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;

/**
 * Created by taow on 2017/8/16.
 */

public class ObservableManager<T> {
    private static ObservableManager manager;
    Observable<T> observable;
    private ObservableManager(){
        observable = Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<T> e) throws Exception {
                LogUtils.i("ObservableManager observable subscribe");
            }
        });
    };

    public static ObservableManager getInstance(){
        if(manager == null){
            return  new ObservableManager();
        }else {
            return manager;
        }
    }

    public void subScribe(Observer<T> observer){
        observable.subscribe(observer);
    }
}
