package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Prog7 {

    public static void main(String[] args) {

        Mono.fromFuture(() -> getName()).subscribe(Util.onNext());

        Util.sleepSeconds(2);

    }

    private static CompletableFuture<String> getName()
    {
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName().toUpperCase());
    }
}
