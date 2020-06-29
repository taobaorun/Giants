package com.jiaxy.giants.akka.com.example;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class FailureHandingExperiments {

    public static void main(String[] args) {

        ActorSystem system = ActorSystem.create("testSystem");

        ActorRef supervisingActor = system.actorOf(SupervisingActor.props(), "supervising-actor");
        supervisingActor.tell("failChild", ActorRef.noSender());
        supervisingActor.tell("restart", ActorRef.noSender());
    }
}
