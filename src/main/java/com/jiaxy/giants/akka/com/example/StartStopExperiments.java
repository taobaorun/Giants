package com.jiaxy.giants.akka.com.example;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class StartStopExperiments {

    public static void main(String[] args) {

        ActorSystem system = ActorSystem.create("testSystem");

        ActorRef startStopActor1 = system.actorOf(StartStopActor1.props(), "startStopActor1");
        System.out.println(startStopActor1);
        startStopActor1.tell("stop", ActorRef.noSender());

    }
}
