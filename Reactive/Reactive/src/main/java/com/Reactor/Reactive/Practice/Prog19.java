package com.Reactor.Reactive.Practice;

import com.Reactor.Reactive.ProjectUtil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class  Prog19 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch= new CountDownLatch(1);

        getPrice().subscribe(new Subscriber<Integer>() {

            Subscription subscription ;
            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription=subscription;
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer price) {

                System.out.println(LocalDateTime.now()+" : price : "+price);
                if(price<90||price>110)
                {
                    System.out.println("Cancelling the  subscription...!");
                    this.subscription.cancel();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("ERROR DUE TO : "+throwable.getMessage());
                countDownLatch.countDown();
            }

            @Override
            public void onComplete() {
                System.out.println("Completed!!!");
                countDownLatch.countDown();
            }
        });

        countDownLatch.await();

    }

    public static Flux<Integer> getPrice()
    {
        AtomicInteger atomicInteger=new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i-> atomicInteger.getAndAccumulate(
                        Util.faker().random().nextInt(-5,5),
                        Integer::sum
                ));

    }

}
