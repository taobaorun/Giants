package com.jiaxy.giants.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigMain {

    public static void main(String[] args) {
        Config conf = ConfigFactory.load("default").withFallback(ConfigFactory.load("myconf"));
        String appName = conf.getConfig("myconf").getString("app.name");
        int appId = conf.getConfig("myconf").getInt("app.id");
        System.out.println(appId);
        System.out.println(appName);
    }
}
