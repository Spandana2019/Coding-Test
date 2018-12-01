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
 * This class is used to test if the string are properly formated based on the below rules
 * 1. If String length is under 30 characters long then it is padded with 0's
 * 2. If String length is over 40 characters long then it is truncated to 40 characters
 *  
 * */

@RunWith(Parameterized.class)
public class FormatStringMethodTest {

	private String expectedResult;
	private String value;
	private String paddingstr;
	private int min;
	private int max;

	public FormatStringMethodTest(String expectedResult, String value, String paddingstr, int min, int max) {

		this.expectedResult = expectedResult;
		this.value = value;
		this.paddingstr = paddingstr;
		this.min = min;
		this.max = max;
	}

	// Test data
	@Parameters
	public static Collection<Object[]> testData() {

		Object[][] data = new Object[][] { { "456442342342342342345000000000", "4564423423423423423450", "0", 30, 40 },
				{ "1239092342342342342342342342342342342342", "12390923423423423423423423423423423423423423345", "0",
						30, 40 },
				{ "34334434534534532535423452345234535245", "34334434534534532535423452345234535245", "0", 30, 40 },
				{ "343344345-3453453253542-3452345234535245", "343344345-3453453253542-3452345234535245", "0", 30,
						40 } };

		return Arrays.asList(data);

	}

	@Test
	public void testProcessNumberMethod() {
		assertEquals(expectedResult, GeneratorController.formatStr(value, paddingstr, min, max));
	}
}
