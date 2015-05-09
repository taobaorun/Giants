package com.jiaxy.giants.hazelcast.distributedmap;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

/**
 * Created by wutao on 14-4-13.
 */
public class FillMapMember {

    public static void main(String[] args){
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getGroupConfig().setName("dev").setPassword("dev-pass");
        clientConfig.getNetworkConfig().addAddress("192.168.1.105", "192.168.1.105:5702");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        Map< String , String > map = client . getMap ( "cities" ) ;
        map.put("1","beijing");
        map.put("2","changsha");
        map.put("3","wuhan");
        client.shutdown();
    }
}
