package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

public class Prog21 {

    public static void main(String[] args) {

//        System.out.println(doSomething().blockFirst());
        doSomething().subscribe(Util.getSubscriber());
    }

    public static Flux<String> doSomething()
    {
        Flux<String> flux= Flux.create(

                fluxSink -> {

                    for(int i=0;i<100;i++)
                    {
                        fluxSink.next(Util.faker().animal().name());
                    }

                }
        );
        return flux;
    }


}
