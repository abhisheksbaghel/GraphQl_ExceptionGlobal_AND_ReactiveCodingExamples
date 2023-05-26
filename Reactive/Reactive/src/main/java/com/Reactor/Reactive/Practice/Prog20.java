package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Flux;

public class Prog20 {

    public static void main(String[] args) {

        Flux.create(
                fluxSink -> {

//                    for (int i = 0; i < 10; i++) {
//                        fluxSink.next(Util.faker().country().name().toUpperCase());
//                    }
                    String country;
                    do{
                        country=Util.faker().country().name().toUpperCase();
                        fluxSink.next(country);
                    }while(!country.equals("INDIA"));

                }
        ).subscribe(Util.getSubscriber("Abhishek"));

    }

}
