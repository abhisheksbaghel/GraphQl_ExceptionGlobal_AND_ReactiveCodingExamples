package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Mono;

public class Prog6 {

    public static void main(String[] args) {
                
        getName();


    }

    private static Mono<String> getName()
    {
            System.out.println("Entered The GETNAME Method");
            return Mono.fromSupplier(
                    () -> {
                        System.out.println("Generating names....");
                        Util.sleepSeconds(3);
                        return Util.faker().name().nameWithMiddle();
                    }
            ).map(String::toUpperCase);
    }

}
