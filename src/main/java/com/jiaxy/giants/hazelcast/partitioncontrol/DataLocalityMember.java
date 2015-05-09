package com.jiaxy.giants.hazelcast.partitioncontrol;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.Partition;
import com.hazelcast.core.PartitionService;

import java.util.Map;

/**
 * Created by wutao on 14-4-13.
 */
public class DataLocalityMember {

    public static void main(String[] args){

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getGroupConfig().setName("dev").setPassword("dev-pass");
        clientConfig.getNetworkConfig().addAddress("192.168.1.105", "192.168.1.105:5702");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        Map< Long , Customer > customerMap = client . getMap ( "customers" ) ;
        Map < OrderKey , Customer.Order> orderMap = client . getMap ( "orders" ) ;
        long customerId = 100;
        long orderId = 200;
        long articleId = 300;
        Customer customer = new Customer ( customerId ) ;
        customerMap . put ( customer . id , customer ) ;
        OrderKey orderKey = new OrderKey ( orderId , customer . id ) ;
        Customer.Order order = customer.new Order(orderKey.orderId,customer.id,articleId );
        orderMap . put ( orderKey , order ) ;
        PartitionService pService = client.getPartitionService() ;
        Partition cPartition = pService . getPartition ( customerId ) ;
        Partition oPartition = pService . getPartition ( orderKey ) ;
        Partition wPartition = pService . getPartition ( orderId ) ;

        System . out . printf ( " Partition for customer : %s \n " ,
                cPartition . getPartitionId () ) ;
        System . out . printf ( " Partition for order with OrderKey : %s \n",
                oPartition . getPartitionId () ) ;
        System . out . printf ( " Partition for order without OrderKey : %s\n",
                wPartition . getPartitionId () ) ;

    }

}
