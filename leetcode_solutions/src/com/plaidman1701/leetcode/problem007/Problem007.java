package com.plaidman1701.leetcode.problem007;

/*
  
https://leetcode.com/problems/reverse-integer/description/

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 
 
 */

public class Problem007 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution soln = new Solution();

		System.out.println(soln.reverse(123));

	}
}

class Solution {
	
	// try refactoring with a mod 10 off the tail
	
	public int reverse(int x) {

		String intAsString;

		try {
			intAsString = Integer.toString(Math.abs(x));
		} catch (Exception e) {
			return 0;
		}

		int returnInt = 0;

		for (int i = 0; i < intAsString.length(); ++i) {
		
			long testLong = returnInt + (long) Math.pow(10, i) * Character.getNumericValue(intAsString.charAt(i));
			
			if (testLong > Integer.MAX_VALUE || testLong < Integer.MIN_VALUE)
			{
				return 0;
			}
			else
			{
				returnInt = (int)testLong;
			}

		}

		returnInt *= (int) Math.signum(x);

		return returnInt;
	}
}