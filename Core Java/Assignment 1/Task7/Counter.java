package com.wipro.assignment1;
public class Counter {
  private int count;

  public Counter() {
    count = 0;
  }

  public synchronized void increment() {
    count++;
  }

  public synchronized void decrement() {
    count--;
  }

  public int getValue() {
    return count;
  }
}
