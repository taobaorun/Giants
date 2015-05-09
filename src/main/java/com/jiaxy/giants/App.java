package com.jiaxy.giants;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSONObject;
import com.jiaxy.giants.fastjson.JSONObjectBean;
import com.jiaxy.giants.hession.HessionWrapper;
import com.jiaxy.giants.jedis.FilterKey;
import com.jiaxy.giants.jedis.model.Key;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final JSONObject source = JSONObjectBean.build();
    	final Jedis jedis = new Jedis("localhost");
    	
    	
    	ScheduledExecutorService exe = Executors.newScheduledThreadPool(10);
    	exe.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("------add--------");
				Key key = new Key();
				LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
				params.put("req", JSONObjectBean.build().toJSONString());
				key.setExpireTime(new Date().getTime() + 2000);
				key.setParamsMap(params);
				jedis.sadd("foo".getBytes(), HessionWrapper.serialize(key));
				
			}
		}, 0, 5, TimeUnit.SECONDS);
    	System.out.println("----remove job----------");
    	ScheduledExecutorService exe2 = Executors.newSingleThreadScheduledExecutor();
    	exe2.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("------remove--------");
				FilterKey.filter();
				
			}
		}, 0, 1, TimeUnit.SECONDS);
    }
}
