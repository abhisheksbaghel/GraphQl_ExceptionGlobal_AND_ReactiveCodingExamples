package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;

public class Prog9Test {

    public static void main(String[] args) {

        Prog9.read("file1.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        Prog9.write("file3.txt","You are reading file3.....").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        Prog9.delete("file2.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

    }

}
