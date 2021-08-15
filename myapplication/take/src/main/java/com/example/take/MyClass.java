package com.example.take;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MyClass {


    public Observable<Integer> getObservable(){
        return Observable.just(1,2,3,4,5);
    }

    Observer<Integer> getObserver(){
        return new Observer<Integer>() {
            @Override
            public void onSubscribe( Disposable d) {

            }

            @Override
            public void onNext( Integer integer) {

                System.out.println("getObserver, onNext :" + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }



    public static void main(String[] args){
        MyClass myClass = new MyClass();
        myClass.getObservable().take(3).subscribe(
                v->System.out.println("onNext() :value :" + v),
                err->System.out.println("onError :err :" + err.getMessage()),
                ()->System.out.println("onComplete"));

        myClass.getObservable().take(4).subscribe(myClass.getObserver());





    }
}