package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Prog15 {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference=new AtomicReference<>();
        Flux.range(1,20).subscribeWith(
                new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Subscription taken : "+subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext Called : "+integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError Called : "+throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                    }
                }
        );

        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        atomicReference.get().request(8);
        Util.sleepSeconds(5);
        System.out.println("Cancelling Subscription");
        atomicReference.get().cancel();
        Util.sleepSeconds(5);
        atomicReference.get().request(10);

    }

}
