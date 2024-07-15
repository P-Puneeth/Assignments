
/*
Task 4: Lambda Expressions
Implement a Comparator for a Person class using a lambda expression, 
and sort a list of Person objects by their age.
*/

package com.wipro.assignment2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task4 {

	public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(30));
        people.add(new Person(25));
        people.add(new Person(35));

        // Comparator using lambda expression
        Comparator<Person> ageComparator = (p1, p2) -> p1.getAge() - p2.getAge();

        // Sort the list using the comparator
        people.sort(ageComparator);

        // Print the sorted list
        people.forEach(person -> System.out.println(person.getAge()));
    }
}
