package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import reactor.core.publisher.Flux;

import java.awt.image.AbstractMultiResolutionImage;
import java.util.ArrayList;
import java.util.List;

public class Prog16 {

    public static void main(String[] args) {

        System.out.println(getNamesList(10));
        getNamesFlux(10).subscribe(
                Util.onNext()
        );
    }
     public static List<String> getNamesList(int count)
     {
         List<String > ls=new ArrayList<>();
         for (int i = 0; i < count; i++) {
             ls.add(getName());
         }

         return ls;
     }

     public static Flux<String> getNamesFlux(int count)
     {
         return Flux.range(1,count).map(i->getName());
     }



     public static String getName()
     {
         Util.sleepSeconds(2);
         return Util.faker().name().fullName().formatted();
     }

}
