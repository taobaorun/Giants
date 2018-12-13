package com.jiaxy.giants.rxjava.quickstart;

import rx.Observable;

/**
 *
 * @version $Id: QuickStart.java, v 0.1 2018年12月13日 14:08 $
 */
public class QuickStart {
    private static String result;

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Hello");
        observable.subscribe(s -> result = s);
        assert result.equals("Hello");

    }
}