
/*
Task 2: Generic Classes and Methods
Implement a generic method that swaps the positions of two elements in an array, regardless of their type,
and demonstrate its usage with different object types.
*/

package com.wipro.assignment2;

public class Task2 {

	// Generic method to swap elements in an array
	public static <T> void swap(T[] array, int index1, int index2) {
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public static void main(String[] args) {
		

		// String array
		String[] strArray = {"puneeth", "mahesh", "kiran"};
		System.out.println("Before swap (String): ");
		printArray(strArray);
		swap(strArray, 0, 2);
		System.out.println("After swap (String): ");
		printArray(strArray);

		// Custom object array
		Person[] personArray = {new Person("puneeth", 25), new Person("mahesh", 30), new Person("sai", 35)};
		System.out.println("Before swap (Person): ");
		printArray(personArray);
		swap(personArray, 1, 2);
		System.out.println("After swap (Person): ");
		printArray(personArray);
	}

	// Method to print elements of an array
	public static <T> void printArray(T[] array) {
		for (T element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	// Custom Person class
	static class Person {
		String name;
		int age;

		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return name + "(" + age + ")";
		}
	}

}
