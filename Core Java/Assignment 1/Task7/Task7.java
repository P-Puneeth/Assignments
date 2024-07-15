
/*
Task 7: Writing Thread-Safe Code, Immutable Objects
Design a thread-safe Counter class with increment and decrement methods. 
Then demonstrate its usage from multiple threads. Also, implement and use an immutable class 
to share data between threads.
 */

package com.wipro.assignment1;

import java.util.concurrent.atomic.AtomicInteger;

public class Task7 {

	public static void main(String[] args) {
		Counter counter = new Counter();

		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
			System.out.println("Thread 1: Counter value - " + counter.getValue());
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.decrement();
			}
			System.out.println("Thread 2: Counter value - " + counter.getValue());
		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final Count: " + counter.getValue());
	}

}
