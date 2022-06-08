/*
 * Copyright 2015-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {
	
	Calculator calculator;

	@BeforeEach
	public void init() {
		this.calculator = new Calculator();
	}
	
	

	@Test
	@DisplayName("1 + 1 = 2")
	void addsTwoNumbers() {
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void add(int first, int second, int expectedResult) {
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}
	
	
	
	@Test
	@DisplayName("5 - 1 = 4")
	void subTwoNumbers() {
		assertEquals(0, calculator.subtrair(1, 1), "1 - 1 should equal 0");
	}
	
	@ParameterizedTest(name = "{6} - {1} = {5}")
	@CsvSource({
			"8,    4,   4",
			"1,    2,   -1",
			"10,  7,  3",
			"25,  24,  1"
	})
	void sub(int first, int second, int expectedResult) {
		assertEquals(expectedResult, calculator.subtrair(first, second),
				() -> first + " - " + second + " should equal " + expectedResult);
	}
	
	

	@Test
	@DisplayName("5 - 1 = 4")
	void multTwoNumbers() {
		assertEquals(2, calculator.multiplicar(2, 1), "2 * 1 should equal 2");
	}
	
	@ParameterizedTest(name = "{5} * {1} = {5}")
	@CsvSource({
			"8,    4,   32",
			"1,    2,   2",
			"10,  7,  70",
			"-1,  24,  -24"
	})
	void mult(int first, int second, int expectedResult) {
		assertEquals(expectedResult, calculator.multiplicar(first, second),
				() -> first + " * " + second + " should equal " + expectedResult);
	}
	
	
	@Test
	@DisplayName("5 / 1 = 5")
	void diviTwoNumbers() {
		assertEquals(2, calculator.dividir(2, 1), "2 / 1 should equal 2");
	}
	
	@ParameterizedTest(name = "{8} / {2} = {4}")
	@CsvSource({
			"8,    4,   2",
			"2,    2,   1",
			"15,  5,  3",
			"5,  4,  1",
			"240,  24,  10"
	})
	void divi(int first, int second, int expectedResult) {
		assertEquals(expectedResult, calculator.dividir(first, second),
				() -> first + " * " + second + " should equal " + expectedResult);
	}
	
	


	@Test()
	@DisplayName("nao deve dividir por 0")
	void naoDeveDividirPorZero() {
		
	Exception exception = assertThrows(ArithmeticException.class, () -> calculator.dividir(1, 0));
	        assertEquals("/ by zero", exception.getMessage());
	}
		
	
	
}
