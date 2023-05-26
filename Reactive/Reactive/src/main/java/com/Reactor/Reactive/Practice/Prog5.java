package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Prog5 {

    public static void main(String[] args) {

//        Mono<String> mono= Mono.just(getName());
//
//        mono.subscribe(
//                Util.onNext()
//        );  ---------------------------->this will call the method and SOP will be printed without subscribing

        Mono<String> mono1= Mono.fromSupplier(() -> getName());

        mono1.subscribe(
                Util.onNext()
        );

        Supplier<String> stringSupplier=() -> getName();

        Mono.fromSupplier(stringSupplier).subscribe(
                Util.onNext()
        );

        Callable<String> stringCallable=() -> getName();

        Mono.fromCallable(stringCallable).subscribe(
                Util.onNext()
        );

    }
    public static String getName()
    {
        System.out.println("Generating data...");
        return Util.faker().name().nameWithMiddle();
    }

}
