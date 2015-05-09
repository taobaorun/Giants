package com.jiaxy.giants.hazelcast.distributedprimitive;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;

/**
 * Created by wutao on 14-4-12.
 */
public class IdGeneratorMember {

    public static void main ( String [] args ) throws Exception {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getGroupConfig().setName("dev").setPassword("dev-pass");
        clientConfig.getNetworkConfig().addAddress("192.168.1.105", "192.168.1.105:5702");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IdGenerator idGenerator = client.getIdGenerator ( " id " ) ;
        for ( int k = 0; k < 1000; k ++) {
            Thread . sleep (1000) ;
            System . out . printf ( " Id : %s \n " , idGenerator.newId () ) ;
        }
    }
}
