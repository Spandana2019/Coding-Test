package com.generator.controller;

import java.util.Random;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * Assumption:
 *   1. Assuming Z contains the minimum length of the sub sequence palindrom in the Random Number
 *   2. Assuming X contains the number that will be used for division when random number is even
 *   3. Assuming Y contains the number that will be added to the random number if random number is odd
 *   4. Assuming positive random numbers are generated
 *                    
 * Flow of the program:
 *   Initial Setup: create a StringBuffer buf for storing the generated sequence numbers.
 * 
 *   1. Generate positive random number, lets say randomNum.
 *   2. Check for the largest palindromic sub sequence in randomNum.
 *   3. If the length of the largest sub sequence in randomNum is greater than or equal to Z goto step (a).
 *           a. Check if randomNum is even, if true then divide randomNum by X and append the result to StringBuffer buf
 *                    otherwise (if odd) add Y to randomNum and append the result to StringBuffer buf
 *                        maintain a counter count1 to keep track of sequence numbers generated using the above process in step 3.
 *   4.  If the randomNum does not contain the palindromic sub sequence then append the randomNum to StringBuffer buf  
 *                     maintain a counter count2 to keep track of sequence numbers generated using the above process in step 4.  
 *   5. If the string length in the StringBuffer buf is greater than or equal to 40 characters long, stop the random number generation.
 *   6. Check the length of the final string in BufferSting buf.
 *   7. If length is under 30 characters long then it is padded with 0's.
 *   8. If length is over 40 characters long then it is truncated to 40 characters.
 *   9. The resulting length is returned.
 *   
 *   This project contain both UuidGeneratorApplication and the Junit test cases.
 *   
 *   The url is localhost:<portnumber>/generateUUID?x=2&y=7&z=5
 *   
 * */

@RestController
public class GeneratorController {

	@Value("${sequence.minLength}")
	private int minSequence;

	@Value("${sequence.maxLength}")
	private int maxSequence;

	@Value("${randomNumber.bound}")
	private int bound;

	// UUID Generator
	@RequestMapping("/generateUUID")
	public String generateUUID(@RequestParam("x") int x, @RequestParam("y") int y, @RequestParam("z") int z) {

		// Initial Setup
		int count1 = 0;
		int count2 = 0;

		// for storing the generated sequence numbers.
		StringBuffer buf = new StringBuffer("");

		while (true) {

			// generate random number
			int number = generateRandomNumber(bound);

			// Check for the largest palindromic sub sequence
			if (largestPalindromicSubsequence(String.valueOf(number)) >= z) {
				buf.append(processNumber(number, x, y));
				// keep track of sequence numbers generated using the process (processNumber)
				++count1;
			} else {
				if (count1 > count2) {// this condition is here to make sure at least half of the string is generated
										// by the process
					buf.append(number);
					// keep track of sequence numbers generated without the process
					++count2;
				}
			}

			// if the string length in the StringBuffer buf is greater than or equal to 40
			// characters long
			// stop the random number generation
			if (buf.toString().length() >= maxSequence)
				break;
		}

		// check for the length of the final string and apply the rules and return the
		// string
		return formatStr(buf.toString(), "0", minSequence, maxSequence);
	}

	// generate random number
	private static int generateRandomNumber(int bound) {
		return new Random().nextInt(bound);
	}

	// check for the length of the final string and apply the rules
	public static String formatStr(String str, String paddingstr, int min, int max) {
		// If length is under min characters long then it is padded with 0's
		if (str.length() < min)
			return String.format("%-" + min + "s", str).replace(" ", paddingstr);
		else {
			// If length is over max characters long then it is truncated to 40 characters
			if (str.length() > max)
				return str.substring(0, max);
		}
		// if it is between min and max return the original string
		return str;
	}

	// Random Number processing
	public static int processNumber(int e, int x, int y) {
		// If the number is even, then divide by x
		// If the number is oSdd, then add y
		return e % 2 == 0 ? e / x : e + y;
	}

	// largest Palindromic Subsequence
	public static int largestPalindromicSubsequence(String str) {

		int maxLength = 1;

		int start = 0;
		int len = str.length();

		int low, high;

		// even and odd length palindromes
		for (int i = 1; i < len; ++i) {
			// Find the largest even length palindrome
			low = i - 1;
			high = i;
			while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}

			// Find the largest odd length palindrome
			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}
		}

		// System.out.print("largest palindromic sub sequence is: ");
		// System.out.println(str.substring(start, start + maxLength));

		return maxLength;
	}

}
