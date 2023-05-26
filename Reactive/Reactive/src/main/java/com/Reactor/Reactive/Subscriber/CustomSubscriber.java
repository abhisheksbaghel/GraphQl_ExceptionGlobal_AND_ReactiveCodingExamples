package com.Reactor.Reactive.Subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class CustomSubscriber implements Subscriber<Object> {

    String name="";

    public CustomSubscriber(String name)
    {
        this.name=name+ " - ";
    }

    public CustomSubscriber()
    {

    }
    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(name+"Received : "+o);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name+"ERROR : "+throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name+"Completed");
    }
}
