package com.jiaxy.giants.hazelcast.partitioncontrol;

import java.io.Serializable;

/**
 * Created by wutao on 14-4-13.
 */
public class Customer implements Serializable {
    public final long id ;

    public Customer ( long id ) {
        this . id = id ;
    }

    public final class Order implements Serializable {
        public final long orderId , customerId , articleId ;
        public Order ( long orderId , long customerId , long articleId ) {
            this . orderId = orderId ;
            this . customerId = customerId ;
            this . articleId = articleId ;
        }
    }

}
