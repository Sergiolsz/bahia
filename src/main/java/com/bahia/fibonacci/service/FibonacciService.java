package com.bahia.fibonacci.service;

import org.springframework.http.ResponseEntity;

import com.bahia.fibonacci.model.Fibonacci;
import com.bahia.fibonacci.model.FibonacciNumber;

public interface FibonacciService {

	ResponseEntity<Fibonacci> getSerieFibonacci(int sizeSequence);
	ResponseEntity<FibonacciNumber> getNumberPositionFibonacci(int sizeSequence, int numberPosition);
}
