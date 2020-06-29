package com.jiaxy.giants.akka.com.example;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class HellWorldActor extends AbstractActor {

    static Props props() {
        return Props.create(HellWorldActor.class, HellWorldActor::new);
    }

    @Override
    public void postStop() throws Exception {
        System.out.println(getSelf() + "stopped");
    }

    public void hello() {
        self().tell("world", ActorRef.noSender());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().matchEquals("hello", f -> {
            hello();
        }).matchEquals("world", f -> {
            System.out.println("Hello" + f);
        }).build();
    }
}
