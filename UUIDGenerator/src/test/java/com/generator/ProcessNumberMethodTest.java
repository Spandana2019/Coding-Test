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
 * This class is used to test if the random number is even, divide random number by X 
 *                    otherwise (if odd) add Y to random number
 * 
 * */

@RunWith(Parameterized.class)
public class ProcessNumberMethodTest {

	private int expectedResult;
	private int value;
	private int x;
	private int y;

	public ProcessNumberMethodTest(int expectedResult, int value, int x, int y) {
		this.expectedResult = expectedResult;
		this.value = value;
		this.x = x;
		this.y = y;
	}

	// Test Data
	@Parameters
	public static Collection<Object[]> testData() {

		Object[][] data = new Object[][] { { 50, 43, 2, 7 }, { 1239092350, 1239092345, 4, 5 }, { 2167, 4334, 2, 7 },
				{ 158609, 634436, 4, 5 } };

		return Arrays.asList(data);

	}

	@Test
	public void testProcessNumberMethod() {
		assertEquals(expectedResult, GeneratorController.processNumber(value, x, y));
	}
}
