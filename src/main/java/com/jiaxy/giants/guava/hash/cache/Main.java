package com.jiaxy.giants.guava.hash.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Cache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.SECONDS).build();
        cache.put("1", "2");
        String value = cache.getIfPresent("1");
        System.out.println(value);
        TimeUnit.SECONDS.sleep(10);
        value = cache.getIfPresent("2");
        System.out.println(value);
    }
}
