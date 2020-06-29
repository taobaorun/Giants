package com.jiaxy.giants.akka.com.example;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

import java.util.Optional;

public class SupervisingActor extends AbstractActor {

    static Props props() {
        return Props.create(SupervisingActor.class, SupervisingActor::new);
    }

    ActorRef child = getContext().actorOf(SupervisedActor.props(), "supervised-actor");

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals(
                        "failChild",
                        f -> {
                            child.tell("fail", getSelf());
                            child.tell("other", getSelf());
                        })
                .matchEquals("restart", f -> {
                    child.tell("restart", getSelf());
                })
                .build();
    }

}

class SupervisedActor extends AbstractActor {
    static Props props() {
        return Props.create(SupervisedActor.class, SupervisedActor::new);
    }

    @Override
    public void preStart() {
        System.out.println("supervised actor started");
    }

    @Override
    public void postStop() {
        System.out.println("supervised actor stopped");
    }

    @Override
    public void preRestart(Throwable reason, Optional<Object> message) throws Exception {
        System.out.println("supervised actor restarted");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals(
                        "fail",
                        f -> {
                            System.out.println("supervised actor fails now");
                            throw new Exception("I failed!");
                        }).
                        matchEquals("restart", f -> {
                            System.out.println("restart msg");
                        }).matchAny(f -> {
                    System.out.println(f);
                })
                .build();
    }
}
