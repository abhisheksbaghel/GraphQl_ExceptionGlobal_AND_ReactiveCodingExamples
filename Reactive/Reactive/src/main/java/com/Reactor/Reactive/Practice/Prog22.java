package com.Reactor.Reactive.Practice;
import java.util.*;
import com.Reactor.Reactive.ProjectUtil.Util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Prog22 {

    public static void main(String[] args) {

        Map<Integer,String> myMap=new ConcurrentHashMap<>();
        for (int i = 0; i < 20; i++) {
            myMap.put(i, Util.faker().name().title().toUpperCase());
        }

        Set<Map.Entry<Integer,String>> entrySet= myMap.entrySet();
        entrySet.stream().map();


    }

}
