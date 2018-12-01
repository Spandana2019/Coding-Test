package com.generator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.generator.controller.GeneratorController;

/*
 * 
 * This class is used to test the largest palindromic sub sequence in the random number
 *  
 * */

@RunWith(Parameterized.class)
public class LongestPalindromTest {

	private int expectedResult;
	private String value;

	public LongestPalindromTest(int expectedResult, String value) {

		this.expectedResult = expectedResult;
		this.value = value;
	}

	// test data
	@Parameters
	public static Collection<Object[]> testData() {

		Object[][] data = new Object[][] { { 6, "12390923456345543342342" }, { 4, "123909234563453444543342342" },
				{ 6, "234345543" }, { 6, "23434554334534" }, { 6, "123909234563443645653444543342342" } };

		return Arrays.asList(data);

	}

	@Test
	public void test1LongestPalindrome() {
		assertEquals(expectedResult, GeneratorController.largestPalindromicSubsequence(value));
	}
}
