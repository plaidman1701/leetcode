package com.plaidman1701.leetcode.problem012;

/*
https://leetcode.com/problems/integer-to-roman/description/

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class Problem012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution soln = new Solution();

		System.out.println(soln.intToRoman(1));
		System.out.println(soln.intToRoman(9));
		System.out.println(soln.intToRoman(11));
		System.out.println(soln.intToRoman(99));
		System.out.println(soln.intToRoman(100));
		System.out.println(soln.intToRoman(101));
		System.out.println(soln.intToRoman(999));

	}

}

class Solution {
	public String intToRoman(int num) {

		StringBuilder returnString = new StringBuilder();

		returnString.append(buildThousands(num));
		returnString.append(buildHundreds(num));
		returnString.append(buildTens(num));
		returnString.append(buildOnes(num));

		return returnString.toString();
	}
	
	private String buildSubstring(int num, char small, char med, char big)
	{
		StringBuilder returnString = new StringBuilder();

		switch (num) {
		case 1:
			returnString.append(small);
			break;
		case 2:
			returnString.append(small).append(small);
			break;
		case 3:
			returnString.append(small).append(small).append(small);
			break;
		case 4:
			returnString.append(small).append(med);
			break;
		case 5:
			returnString.append(med);
			break;
		case 6:
			returnString.append(med).append(small);
			break;
		case 7:
			returnString.append(med).append(small).append(small);
			break;
		case 8:
			returnString.append(med).append(small).append(small).append(small);
			break;
		case 9:
			returnString.append(small).append(big);
			break;
		case 0:
		default:
			break;
		}
		
		return returnString.toString();
	}

	private String buildThousands(int thousands) {
		
		thousands = thousands / 1000;		
		return buildSubstring(thousands, 'M', 'M', 'M'); // not accurate, but values will always be < 4000 anyway
		
	}
	


	private String buildHundreds(int hundreds) {
		
		hundreds = hundreds % 1000 / 100;
		return buildSubstring(hundreds, 'C', 'D', 'M');
		
	}
	
	private String buildTens(int tens)
	{
		
		tens = tens % 100 / 10;
		return buildSubstring(tens, 'X', 'L', 'C');
		
	}
	
	private String buildOnes(int ones)
	{
		ones = ones % 10;
		return buildSubstring(ones, 'I', 'V', 'X');
	}
}