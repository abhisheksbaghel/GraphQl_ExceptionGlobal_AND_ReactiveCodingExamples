package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Mono;

public class Prog4 {

    public static void main(String[] args) {

        userRepository(3 ).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

    }

    public static Mono<String> userRepository(int userid)
    {
        if(userid==1)
        {
            return Mono.just(Util.faker().name().fullName());
        } else if (userid==2)
        {
            return Mono.empty(); //instead of null send this...it will handle null pointer
        }
        else
        {
            return Mono.error(new RuntimeException("out of range exception"));
        }
    }
}
