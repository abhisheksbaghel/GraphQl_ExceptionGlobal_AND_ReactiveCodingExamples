package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Prog12 {

    public static void main(String[] args) {

        Flux<String> flux= Flux.fromIterable(countryList(10));
        flux.subscribe(Util.onNext());


        flux.filter(str-> str.startsWith("A")).subscribe(
                item-> System.out.println("Starting with A : "+item)
        );
    }

    public static List<String> countryList(int i)
    {
        List<String> list= new ArrayList<>();
        for(int j=0;j<=i;j++)
        {
            list.add(Util.faker().country().capital().toUpperCase());
        }
        return list;
    }

}
