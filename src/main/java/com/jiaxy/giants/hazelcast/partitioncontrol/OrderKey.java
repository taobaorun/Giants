package com.jiaxy.giants.hazelcast.partitioncontrol;

import com.hazelcast.core.PartitionAware;

import java.io.Serializable;

/**
 * Created by wutao on 14-4-13.
 */
public class OrderKey implements PartitionAware,Serializable {

    public final long orderId , customerId ;

    public OrderKey ( long orderId , long customerId ) {
        this . orderId = orderId ;
        this . customerId = customerId ;
    }


    @Override
    public Object getPartitionKey() {
        return customerId ;
    }
}
