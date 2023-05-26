package com.Reactor.Reactive.ProjectUtil;

import com.Reactor.Reactive.Subscriber.CustomSubscriber;
import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

public class Util {

    private static final Faker FAKER= Faker.instance();
    public static Consumer<Object> onNext()
    {
        return o -> {System.out.println("Received : "+o);};
    }

    public static Consumer<Throwable> onError()
    {
        return e -> {System.out.println(e.getMessage());};
    }

    public static Runnable onComplete()
    {
        return () -> {System.out.println("Completed");};
    }

    public static Faker faker()
    {
        return FAKER;
    }

    public static void sleepSeconds(int sec)
    {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Subscriber<Object> getSubscriber()
    {
        return new CustomSubscriber();
    }

    public static Subscriber<Object> getSubscriber(String name)
    {
        return new CustomSubscriber(name);
    }

}
