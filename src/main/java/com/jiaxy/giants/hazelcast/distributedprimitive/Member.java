package com.jiaxy.giants.hazelcast.distributedprimitive;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;

/**
 * Created by wutao on 14-4-12.
 */
public class Member {


    public static void main(String[] args){
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getGroupConfig().setName("dev").setPassword("dev-pass");
        clientConfig.getNetworkConfig().addAddress("192.168.1.105", "192.168.1.105:5702");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IAtomicLong counter = client.getAtomicLong(" counter ") ;
        for ( int k = 0; k < 1000 * 1000; k ++) {
            if ( k % 500000 == 0) {
                System . out . println ( " At : " + k ) ;
            }
            counter . incrementAndGet () ;
        }
        System. out.printf( " Count is %s \n " , counter . get () ) ;
        System.exit(0) ;
    }
}
