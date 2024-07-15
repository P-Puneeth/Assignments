
/*
Task 4: Synchronized Blocks and Methods
Write a program that simulates a bank account being accessed by multiple threads 
to perform deposits and withdrawals using synchronized methods to prevent race conditions.
*/

package com.wipro.assignment1;

public class Task4 {

	private int balance = 0;

	// Synchronized method for deposit
	public synchronized void deposit(int amount) {
		balance += amount;
		System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", Balance: " + balance);
	}

	// Synchronized method for withdrawal
	public synchronized void withdraw(int amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", Balance: " + balance);
		} else {
			System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + ", but insufficient balance. Balance: " + balance);
		}
	}

	public int getBalance() {
		return balance;
	}

	public static void main(String[] args) {
		Task4 account = new Task4();

		// Creating multiple threads to perform deposits and withdrawals
		Thread t1 = new Thread(() -> {
			account.deposit(100);
			account.withdraw(50);
		}, "Thread 1");

		Thread t2 = new Thread(() -> {
			account.deposit(200);
			account.withdraw(150);
		}, "Thread 2");

		Thread t3 = new Thread(() -> {
			account.withdraw(100);
			account.deposit(50);
		}, "Thread 3");

		// Starting the threads
		t1.start();
		t2.start();
		t3.start();

		// Joining the threads to wait for their completion
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Final balance
		System.out.println("Final balance: " + account.getBalance());
	}
}

