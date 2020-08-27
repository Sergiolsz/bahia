package com.bahia.fibonacci.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bahia.fibonacci.controller.FibonacciController;
import com.bahia.fibonacci.model.Fibonacci;
import com.bahia.fibonacci.model.FibonacciNumber;
import com.bahia.fibonacci.service.FibonacciServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {FibonacciController.class, FibonacciServiceImpl.class})
public class FibonacciTest {

	@InjectMocks
	FibonacciController fibonacciController;
	
	@MockBean
	FibonacciServiceImpl fibonacciServiceImpl;
	
	@Mock
	Fibonacci mockFibonacci;
	
	@Mock
	FibonacciNumber mockFibonacciNumber;
	
	
	@BeforeEach
	void setup() {
		Fibonacci mockFibonacci = new Fibonacci();
		FibonacciNumber mockFibonacciNumber = new FibonacciNumber();
		
		List<Integer> mockListFibonacci = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
		mockFibonacci.setSequence(mockListFibonacci);
		
		mockFibonacciNumber.setSequence(mockListFibonacci);
		mockFibonacciNumber.setPosition("The number chosen from the Fibonacci series is: " + 8);
		
		Mockito.when(fibonacciServiceImpl.getSerieFibonacci(10))
		.thenReturn(new ResponseEntity<>(mockFibonacci, HttpStatus.OK));
		
		Mockito.when(fibonacciServiceImpl.getNumberPositionFibonacci(10, 6))
		.thenReturn(new ResponseEntity<>(mockFibonacciNumber, HttpStatus.OK));
	}
	
	@Test
	void testGetSerieFibonacci() {
		ResponseEntity<Fibonacci> responseFibonacci = fibonacciController.getSerieFibonacci(10);
		
		assertTrue(responseFibonacci.getStatusCode().is2xxSuccessful());
		assertNotNull(responseFibonacci.getBody());
		
		assertEquals(10, responseFibonacci.getBody().getSequence().size());
	}
	
	@Test
	void testGetNumberPositionFibonacci() {
		ResponseEntity<FibonacciNumber> responseFibonacciNumber = fibonacciController.getNumberPositionFibonacci(10, 6);
		
		assertTrue(responseFibonacciNumber.getStatusCode().is2xxSuccessful());
		assertNotNull(responseFibonacciNumber.getBody());
		
		assertEquals(10, responseFibonacciNumber.getBody().getSequence().size());
		assertEquals("8", responseFibonacciNumber.getBody().getPosition().substring(responseFibonacciNumber.getBody().getPosition().length() -1));
	}

}
