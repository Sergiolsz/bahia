package com.bahia.fibonacci.model;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("Fibonacci Model")
@Data
@Component
public class Fibonacci {
	
	private List<Integer> sequence;
}
