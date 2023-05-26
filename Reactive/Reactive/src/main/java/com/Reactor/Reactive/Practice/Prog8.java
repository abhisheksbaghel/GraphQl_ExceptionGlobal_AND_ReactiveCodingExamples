package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Mono;

public class Prog8 {

    public static void main(String[] args) {


        Mono.fromRunnable(timeConsumingProcess()).subscribe(
                Util.onNext(),
                Util.onError(),
                () -> {
                    System.out.println("Process is done completing its task");
                }
        );


    }

    private static Runnable timeConsumingProcess()
    {
        return () -> {
            Util.sleepSeconds(3);
            //Util.faker().name().prefix().startsWith("I");
            System.out.println("Operation Completed");
        };
    }


}
