package com.apple.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFunctionalProgramming {

	public static void main(String[] args) {
	      List<String> stringList = Arrays.asList("Hello", "World", "How", "Are", "You", "Today");

	        // imperative declaration
	        List<String> filteredList = new ArrayList<>();

	        for (String string: stringList) {
	            if (string.equals("Hello") || string.equals("Are")) {
	                filteredList.add(string);
	            }
	        }

	        List<String> mappedList = new ArrayList<>();
	        for (String string: filteredList) {
	            mappedList.add(string + " String");
	        }

	        for (String string: mappedList) {
	            System.out.println(string);
	        }
	        
	        
	        //functional style
	        stringList.stream()
	                .filter(s -> s.equals("Hello") || s.equals("Are"))
	                .map(s -> s + " String")
	                .forEach(System.out::println);
	}

}
