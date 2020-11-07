package ru.pa4ok.demoexam;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable task = () -> {
            System.out.println(Thread.currentThread().getName());
            return "Hello, World!";
        };
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();
        Thread.sleep(5000);
        System.out.println(1);
        System.out.println(future.get());
        System.out.println(2);
    }
}
