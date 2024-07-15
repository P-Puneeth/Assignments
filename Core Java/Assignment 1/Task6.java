
/*
Task 6: Executors, Concurrent Collections, CompletableFuture
Use an ExecutorService to parallelize a task that calculates prime numbers 
up to a given number and then use CompletableFuture to write the results to a file asynchronously.
*/

package com.wipro.assignment1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Task6 {

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        int i = 5;
        while (i * i <= num) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
            i += 6;
        }
        return true;
    }

    public static List<Integer> findPrimes(int limit, ExecutorService executor) {
        List<Integer> primes = new ArrayList<>();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        IntStream.rangeClosed(2, limit) 
        .mapToObj(num -> CompletableFuture.runAsync(() -> { 
            if (isPrime(num)) {
                synchronized (primes) {
                    primes.add(num);
                }
            }
        }, executor))
        .collect(Collectors.toList());
        
        CompletableFuture<Void>[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture.allOf(futuresArray).join();

        return primes;
    }

    public static void writePrimesToFile(List<Integer> primes, String fileName) {
        CompletableFuture<Void> writeTask = CompletableFuture.runAsync(() -> {
            try (FileWriter writer = new FileWriter(fileName)) {
                for (int prime : primes) {
                    writer.write(prime + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writeTask.join();
    }

    public static void main(String[] args) {
        int limit = 100000;
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Integer> primes = findPrimes(limit, executor);
        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        writePrimesToFile(primes, "primes.txt");
    }
}

