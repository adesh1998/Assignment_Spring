package com.assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.assignment.exception.NullExceptionHand;
import com.assignment.model.CalculatorModel;
import com.assignment.service.CalculatorService;

@RestController

public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;

	/*
	 * Method used for Addition Subtraction Multiply,DIvide,Modulo
	 * 
	 */
	@PostMapping("/calculator")
	public ResponseEntity<?> postResult(@Valid @RequestBody CalculatorModel calculatorModel) {
		String calculate = "";
		if (calculatorModel.getOperationName() == "") {

			throw new NullExceptionHand("Field Cannot be Empty");

		}
		calculate = calculatorService.postResult(calculatorModel);

		return new ResponseEntity<>(calculate, HttpStatus.OK);

	}
	/*
	 * This method display All the operation in current session
	 * 
	 */

	@GetMapping("/calculator")
	public ResponseEntity<?> getResult() {
		List<String> calculatorModel = null;

		calculatorModel = calculatorService.getResult();

		return new ResponseEntity<>(calculatorModel, HttpStatus.OK);

	}

	@PostMapping("/calculator/{id}")
	public ResponseEntity<?> getResultById(@PathVariable("id") int id) {
		CalculatorModel calculatorModel = null;
		calculatorModel = calculatorService.getResultById(id);
		if (calculatorModel == null) {

			throw new NullExceptionHand("Not Found");

		}
		String result = "Result:" + calculatorModel.getOperationName() + " of " + calculatorModel.getNumber1() + " and "
				+ calculatorModel.getNumber2() + " is " + calculatorModel.getResult();
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

}
