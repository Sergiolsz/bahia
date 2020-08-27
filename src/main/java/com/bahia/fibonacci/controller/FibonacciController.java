package com.bahia.fibonacci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bahia.fibonacci.model.Fibonacci;
import com.bahia.fibonacci.model.FibonacciNumber;
import com.bahia.fibonacci.service.FibonacciServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "Fibonacci Sequence Service")	
@RequestMapping("/bahia")
@Controller
public class FibonacciController {
	
	@Autowired
	FibonacciServiceImpl fibonacciService;
	
	@ApiOperation(value = "Get a sequence of Fibonacci numbers for a given size", response = Fibonacci.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully obtained the Fibonacci sequence"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The service is not available.")
	})
	@GetMapping("/fibonacci/{sizeSequence}")
	public ResponseEntity<Fibonacci> getSerieFibonacci(@PathVariable int sizeSequence) {
		return fibonacciService.getSerieFibonacci(sizeSequence);
	}
	
	@ApiOperation(value = "Get the selected number from the sequence by a given size", response = FibonacciNumber.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully obtained the Fibonacci number"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "The service is not available.")
	})
	@GetMapping("/fibonacci/{sizeSequence}/{numberPosition}")
	public ResponseEntity<FibonacciNumber> getNumberPositionFibonacci(@PathVariable int sizeSequence, @PathVariable int numberPosition) {
		return fibonacciService.getNumberPositionFibonacci(sizeSequence, numberPosition);
	}
	
}
