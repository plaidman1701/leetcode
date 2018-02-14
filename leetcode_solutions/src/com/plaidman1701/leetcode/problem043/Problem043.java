package com.plaidman1701.leetcode.problem043;

/*
https://leetcode.com/problems/multiply-strings/description/

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

public class Problem043 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution soln = new Solution();
		
		System.out.println(soln.multiply("123", "0"));

	}

}

class Solution {
    public String multiply(String num1, String num2) {
    	
    	// quick catches
    	if (num1.equals("0") || num2.equals("0"))
    	{
    		return "0";
    	}
    	if (num1.equals("1"))
    	{
    		return num2;
    	}
    	if (num2.equals("1"))
    	{
    		return num1;
    	}
    	
    	
    	String returnString = "";
    	
    	for (int i = 0; i < num1.length();  ++i)
    	{
    		int baseInt = Character.getNumericValue(num1.charAt(num1.length() - 1 - i));
    		returnString = addTwoStrings(returnString, multiplyStringAndInt(num2, baseInt, i));
    	}
    	
    	return returnString;  
    }
    
    private String multiplyStringAndInt(String s1, int toMultiply, int orderOfMag)
    {
    	StringBuilder returnString = new StringBuilder();
    	
    	// we're going to build the string BACKWARDS, and then reverse it
    	for (int i = 0; i < orderOfMag; ++i)
    	{
    		returnString.append('0');
    	}
    	
    	int carry = 0;
    	
    	for (int i = s1.length() - 1; i >= 0; --i)
    	{
    		int nextInt = Character.getNumericValue(s1.charAt(i));
    		
    		int sum = ((nextInt * toMultiply) + carry) % 10;
    		carry = ((nextInt * toMultiply) + carry) / 10;
    		
    		returnString.append(sum);
    	}
    	
    	if (carry > 0)
    	{
    		returnString.append(carry);
    	} 	
    	
    	return returnString.reverse().toString();
    	
    }
    
    private String addTwoStrings(String s1, String s2)
    {
    	int firstint = 0;
		int secondint = 0;
		int carry = 0;
		
		StringBuilder returnString = new StringBuilder();
    	
    	// we're going to build the string BACKWARDS, and then reverse it
    	for (int i = 0; i < Math.max(s1.length(), s2.length()); ++i)
    	{
    		firstint = (s1.length() > i ? Character.getNumericValue((s1.charAt(s1.length() - 1 - i))) : 0);
    		secondint = (s2.length() > i ? Character.getNumericValue((s2.charAt(s2.length() - 1 - i))) : 0);
    		
    		int sum = (firstint + secondint + carry) % 10;
    		carry = (firstint + secondint + carry) / 10;
    		
    		returnString.append(sum);
    	}
    	
    	if (carry > 0)
    	{
    		returnString.append(carry);
    	}
    	
    	// don't forget to trim leading 0's
    	String tempString = returnString.reverse().toString().replaceAll("^0+", "");
    	if (tempString.isEmpty())
    	{
    		tempString = "0";
    	}
    	return tempString;
    }
}