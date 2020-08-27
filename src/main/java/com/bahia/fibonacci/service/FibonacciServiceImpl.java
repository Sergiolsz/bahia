package com.bahia.fibonacci.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bahia.fibonacci.model.Fibonacci;
import com.bahia.fibonacci.model.FibonacciNumber;
import com.bahia.fibonacci.utils.FibonacciUtils;

@Service
public class FibonacciServiceImpl implements FibonacciService {
	
	@Autowired
	Fibonacci fibonacci;
	
	@Autowired
	FibonacciNumber fibonacciNumber;

	@Override
	public ResponseEntity<Fibonacci> getSerieFibonacci(int sizeSequence) {
		
		List<Integer> listNumbersSequence = new ArrayList<>();
		
		for (int i = 0; i < sizeSequence; i++) {
			listNumbersSequence.add(FibonacciUtils.fibonacciRecursive(i));
		}
		
		fibonacci.setSequence(listNumbersSequence);
		
		return ResponseEntity.ok().body(fibonacci);
	}

	@Override
	public ResponseEntity<FibonacciNumber> getNumberPositionFibonacci(int sizeSequence, int numberPosition) {
		
		if(numberPosition > sizeSequence) {
			fibonacciNumber.setSequence(null);
			fibonacciNumber.setPosition("You have entered a wrong place value");
			
			return ResponseEntity.badRequest().body(fibonacciNumber);
		}
		
		int position = FibonacciUtils.getListNumbers(sizeSequence).get(numberPosition - 1);
		String resultPosition = "The number chosen from the Fibonacci series is: " + position;
		
		fibonacciNumber.setSequence(FibonacciUtils.getListNumbers(sizeSequence));
		fibonacciNumber.setPosition(resultPosition);
		
		return ResponseEntity.ok().body(fibonacciNumber);
	}

}
