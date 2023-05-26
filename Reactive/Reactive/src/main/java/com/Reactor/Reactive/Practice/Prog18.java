package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Prog18 {

    public static void main(String[] args) {

        Flux.range(1,10)
                .filter(i-> i>3)
                .next().
                subscribe(Util.onNext());

    }

}
