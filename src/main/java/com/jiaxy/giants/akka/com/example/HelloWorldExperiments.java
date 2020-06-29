package com.jiaxy.giants.akka.com.example;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class HelloWorldExperiments {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("HelloWorldSystem");
        ActorRef hello = system.actorOf(HellWorldActor.props(), "helloworld");
        hello.tell("hello", ActorRef.noSender());
        system.terminate();
    }
}
