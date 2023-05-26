package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Flux;

public class Prog11 {

    public static void main(String[] args) {

        Flux<Integer> flux= Flux.just(1, 2, 3, 4, 5, 6);

        flux.subscribe(
                (item)-> System.out.println("From Sub1 : "+item),
                Util.onError(),
                Util.onComplete()
        );
        flux.filter(i-> i%2==0).subscribe(
                (item)-> System.out.println("From Sub2 : "+item),
                Util.onError(),
                Util.onComplete()
        );

    }

}
