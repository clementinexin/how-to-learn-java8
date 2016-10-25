package java8inaction.chap11;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * Created by daijiajia on 16/10/21.
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException {

        List<String> l = new ArrayList<>();
        l.add("1");
        l.add("2");
        l.add("3");
        CountDownLatch latch = new CountDownLatch(2);

        l.stream().forEach(a -> System.out.println(a));

//        test1(l, latch);
        test2(l, latch);
        latch.await();

        System.out.println("first two job done");

        Thread.currentThread().join();

    }

    public static void test1(List<String> l, CountDownLatch latch) {

        CompletableFuture[] futures = l.stream().map(a -> CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " " + a + " start");
            try {
                Thread.sleep(new Random().nextInt(10000));
                return a;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "";
        })).map(future -> future.thenAccept((param -> {
            latch.countDown();
            System.out.println(new Date());
            System.out.println(Thread.currentThread().getName() + " " + param + " done");
        }))).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();

    }

    public static void test2(List<String> l, CountDownLatch latch) {

        l.stream().map(a -> CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " " + a + " start");
            try {
                Thread.sleep(new Random().nextInt(10000));
                return a;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "";
        })).forEach(future -> future.thenAccept((param -> {
            System.out.println(new Date());
            System.out.println(Thread.currentThread().getName() + " " + param + " done");
            latch.countDown();
        })));

//        CompletableFuture.allOf(futures).join();
    }

}
