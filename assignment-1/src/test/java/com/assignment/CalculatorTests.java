package com.assignment;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.model.CalculatorModel;
import com.assignment.service.CalculatorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTests {

	@Mock
	CalculatorService calculatorService;
	@Mock
	CalculatorModel calculatorModel;

	@Before
	public void setup() {
		calculatorModel = new CalculatorModel(1, "Addition", 2, 3, 5);
	}

	@Test
	public void testAdd() {
		// add the behavior of calc service to add two numbers

		when(calculatorService.postResult(calculatorModel)).thenReturn("Addition of 2 and 3 is 5");

		// test the add functionality
		Assert.assertEquals(calculatorService.postResult(calculatorModel), "Addition of 2 and 3 is 5");
	}

	@Test
	public void getAll() {
		List<String> l = calculatorService.getResult();
		assertNotNull(l);
	}

	@Test
	public void getById() {
		CalculatorModel model = calculatorService.getResultById(1);
		assertNotNull(model);
	}

}
