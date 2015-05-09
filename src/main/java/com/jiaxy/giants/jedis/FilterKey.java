/**
 * author wutao
 * copyright www.jiaxy.com
 * 下午12:09:09
 */
package com.jiaxy.giants.jedis;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import com.jiaxy.giants.jedis.model.Key;
import com.jiaxy.giants.hession.HessionWrapper;

import redis.clients.jedis.Jedis;

/**
 * @author wutao
 *
 */
public class FilterKey {
	
	
	public static void filter(){
		final Jedis jedis = new Jedis("localhost");
		Set<byte[]> keys = jedis.smembers("foo".getBytes());
		if ( keys != null ){
			System.out.println(" key size :"+keys.size());
			int size =0;
			for( Iterator<byte[]> it = keys.iterator();it.hasNext();){
				byte[] keyByte = it.next();
				Key key = (Key) HessionWrapper.deserialize(keyByte);
				System.out.println("---key"+key);
				Date currentDate = new Date();
				if ( currentDate.getTime() > key.getExpireTime()){
					jedis.srem("foo".getBytes(), keyByte); 
					System.out.println("remove key "+key);
					size++;
				}
			}
			System.out.println(" remove "+size+" keys");
			System.out.println("after filter key size :"+jedis.smembers("foo".getBytes()).size());
		}
	}

}
