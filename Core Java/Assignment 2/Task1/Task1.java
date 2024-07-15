
/*
Task 1: Generics and Type Safety
Create a generic Pair class that holds two objects of different types, 
and write a method to return a reversed version of the pair.
*/


package com.wipro.assignment2;
public class Task1<T, U> {

	private T first;
	private U second;

	// Constructor
	public Task1(T first, U second) {
		this.first = first;
		this.second = second;
	}


	public T getFirst() {
		return first;
	}

	public U getSecond() {
		return second;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public void setSecond(U second) {
		this.second = second;
	}

	// Method to return a reversed version of the pair
	public Task1<U, T> reverse() {
		return new Task1<>(second, first);
	}

	@Override
	public String toString() {
		return "Pair{" +
				"first=" + first +
				", second=" + second +
				'}';
	}


	
	public static void main(String[] args) {
		Task1<String, Integer> pair = new Task1<>("Hello", 123);
		System.out.println("Original Pair: " + pair);

		Task1<Integer, String> reversedPair = pair.reverse();
		System.out.println("Reversed Pair: " + reversedPair);
	}

}
