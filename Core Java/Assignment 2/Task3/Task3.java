
/*
Task 3: Reflection API 
Use reflection to inspect a class's methods, fields, and constructors, 
and modify the access level of a private field, setting its value during runtime
*/

package com.wipro.assignment2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task3 {
	public static void main(String[] args) {
		try {
			Class<?> example = Example.class;

			// Inspect constructors
			System.out.println("Constructors:");
			Constructor<?>[] constructors = example.getDeclaredConstructors();
			for (Constructor<?> constructor : constructors) {
				System.out.println(constructor);
			}

			// Inspect fields
			System.out.println("\nFields:");
			Field[] fields = example.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field);
			}

			// Inspect methods
			System.out.println("\nMethods:");
			Method[] methods = example.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method);
			}

			// Create an instance of Example
			Object exampleInstance = example.getDeclaredConstructor().newInstance();

			// Access and modify the private field
			Field privateField = example.getDeclaredField("privateField");
			privateField.setAccessible(true); // Make the private field accessible
			privateField.set(exampleInstance, "Mahesh");

			// Verify the new value of the private field
			String fieldValue = (String) privateField.get(exampleInstance);
			System.out.println("\nNew value of privateField: " + fieldValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
