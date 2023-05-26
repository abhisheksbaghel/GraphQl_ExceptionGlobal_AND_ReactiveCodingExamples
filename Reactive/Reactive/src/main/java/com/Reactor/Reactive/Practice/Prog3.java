package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

public class Prog3 {
    public static void main(String[] args) {

        Logger LOGGER = Logger.getLogger(Prog3.class.getName());


        LOGGER.info("About to get an error");

        Mono<Integer> mono=Mono.just("ball")
                .map(String::length)
                .map(l->l/1);

        //mono.subscribe();

        mono.subscribe(

                Util.onNext(),
                Util.onError(),
                Util.onComplete()

        );
    }
}
