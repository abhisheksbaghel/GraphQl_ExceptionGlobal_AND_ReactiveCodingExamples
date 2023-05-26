package com.Reactor.Reactive.Practice;

import ch.qos.logback.core.net.SyslogOutputStream;
import reactor.core.publisher.Mono;

public class Prog2 {
    public static void main(String[] args) {

        Mono<String> mono=Mono.just("ball");

        //mono.subscribe();

        mono.subscribe(

                item-> System.out.println(item),
                err-> System.out.println(err.getMessage()),
                ()-> System.out.println("Completed")
                //item-> System.out.println(item)
        );
    }

}
