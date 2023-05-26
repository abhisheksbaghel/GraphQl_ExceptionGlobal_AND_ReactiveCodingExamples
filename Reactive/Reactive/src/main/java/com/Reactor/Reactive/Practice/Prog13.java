package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Flux;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Prog13 {

    public static void main(String[] args) {

        //List<Integer> list=List.of(1,2,3,4,5);
        List<Integer> list= Arrays.asList(11,22,33,44,55);

        Stream<Integer> stream=list.stream();
        Flux<Integer> flux= Flux.fromStream(()->list.stream());

        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());

    }

}
