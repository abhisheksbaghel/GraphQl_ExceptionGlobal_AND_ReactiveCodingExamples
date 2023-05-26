package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Flux;

public class Prog14 {

    public static void main(String[] args) {

        Flux<Integer> flux= Flux.range(1,10);

         flux.
                log(). //to print the logs for the variables data passing
                map(item-> Util.faker().funnyName().name()).
                log().
                subscribe(Util.onNext());

    }

}
