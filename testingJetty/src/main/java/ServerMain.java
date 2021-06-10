package main.java;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

import static java.lang.Thread.sleep;

public class ServerMain {

    private void exampleWithBasicThreads() {
        TestingThread t1 = new TestingThread("Thread 1", 10000);
        TestingThread t2 = new TestingThread("Thread 2", 500);

        // wrap the class that implements runnable in a Thread and invoke the start method
        new Thread(t1).start();
        new Thread(t2).start();
    }

    private void examplesWithCompleteableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(future1, future2, future3);

        // waits until the combined future is complete
        combinedFuture.get();
        System.out.println(future1.isDone());
        System.out.println(future2.isDone());
        System.out.println(future3.isDone());
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

}