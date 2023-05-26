package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Prog17 {

    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());

        Util.sleepSeconds(5);


        Mono<Object> mono= Mono.just("Abhishek");
        Flux<Object> flux= Flux.from(mono); //convert FLUX from MONO
        doSomething(flux);
        //doSomething(mono); will give error

    }

    public static void doSomething(Flux flux)
    {
        System.out.println("****");
        flux.subscribe(Util.onNext());
    }

}
