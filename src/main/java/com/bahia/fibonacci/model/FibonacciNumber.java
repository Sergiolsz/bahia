package com.bahia.fibonacci.model;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("Fibonacci List and Number Model")
@Data
@Component
public class FibonacciNumber {

	private List<Integer> sequence;
	private String position;
}
