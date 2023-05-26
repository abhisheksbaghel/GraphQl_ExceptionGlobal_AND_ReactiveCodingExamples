package com.Reactor.Reactive.Practice;

import reactor.core.publisher.Mono;

public class Prog1 {

    public static void main(String[] args) {


        Mono<Integer> mono= Mono.just(1);

        System.out.println(mono);
        mono.subscribe(i->System.out.println("Received : "+i));

    }

}
