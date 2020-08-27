package com.bahia.fibonacci.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FibonacciUtils {

	/**
	 * Method that builds a Fibonacci sequence
	 * 
	 * @param number
	 * @return Fibonacci Sequence
	 */
	public static int fibonacciRecursive(int number) {
		if (number < 2) {
			return number;
		}
		
		return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
	}
	
	/**
	 * Method to create a Fibonacci sequence and choose a number from the list
	 * 
	 * @param sizeList
	 * @return Fibonacci sequence and number chosen from the list
	 */
	public static List<Integer> getListNumbers(int sizeList) {
		List<Integer> listNumbersSequence = new ArrayList<>();
		
		for (int i = 0; i < sizeList; i++) {
			listNumbersSequence.add(FibonacciUtils.fibonacciRecursive(i));
		}
		
		return listNumbersSequence;
	}
}
