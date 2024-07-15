
/*
Task 5: Thread Pools and Concurrency Utilities
Create a fixed-size thread pool and submit multiple tasks that perform complex 
calculations or I/O operations and observe the execution.
 */

package com.wipro.assignment1;
import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;

public class Task5 {


	public static void main(String[] args) {

		int limit = 2;

		ExecutorService pool = Executors.newFixedThreadPool(limit);

		// task with some calculations
		Runnable task = () -> {
			for (int i = 0; i < 100000; i++) {
				Math.random();
			}
			System.out.println("Worker Thread finished its job!");
		};

		// Submit 10 tasks to the pool
		for (int i = 0; i < 10; i++) {
			pool.submit(task);
		}

		// Shutdown the pool when done
		pool.shutdown();
	}
}
