package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Prog10FluxStart {

    public static void main(String[] args) {

        Flux<Object> flux= Flux.just(
                Util.faker().country().name(),
                Util.faker().country().name(),
                callNames(10),
                1, 2, 3, 4
        );

        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );


    }

    public static String callNames(int i)
    {
        if(i==0)
        {
            return Util.faker().name().nameWithMiddle().toUpperCase();
        }
        else
        {
            //System.out.println(Util.faker().name().nameWithMiddle());
            return callNames(i-1);
        }
    }


}
