package com.plaidman1701.leetcode.problem007;

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