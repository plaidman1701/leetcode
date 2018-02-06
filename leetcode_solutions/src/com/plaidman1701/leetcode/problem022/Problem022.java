package com.plaidman1701.leetcode.problem022;

/*
https://leetcode.com/problems/generate-parentheses/description/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		printStrings(soln.generateParenthesis(4));

	}
	
	private static void printStrings (List<String> listToPrint)
	{
		for (String s : listToPrint)
		{
			System.out.println(s);
		}
	}

}


class Solution {
    public List<String> generateParenthesis(int n) {
    	
    	List<String> returnList = new ArrayList<String>();
    	
    	int[] openParArray = new int[n];
    	
    	// initialize array. Each index is the first, second etc open parenthesis. The value is its index in the string.
    	for (int i = 0; i < openParArray.length; ++i)
    	{
    		openParArray[i] = i;
    	}
    	
    	while (openParArray[0] != 1) // openParArray[0] can only ever equal 0, use 1 as a termination flag
    	{
    		returnList.add(arrayToString(openParArray));
    		
    		promoteArray(openParArray);
    	}
    	
    	return returnList;
        
    }
   
    
    private static String arrayToString(int[] arr)
    {
    	char[] charArray = new char[arr.length * 2];
    	Arrays.fill(charArray, ')');
    	StringBuilder returnString = new StringBuilder(new String(charArray)); // all closing brackets
    	
    	for (int i = 0; i < arr.length; ++i)
    	{
    		returnString.setCharAt(arr[i], '(');
    	}    	
    	
    	return returnString.toString();
    	
    }
    
    // promotes the array's values to the next increment, starting with the last open parenthesis
    // for every index i, the limits are i <= arr[i] <= i * 2
    // updates by reference only, returns nada
    private static void promoteArray(int[] arr)
    {
    	for (int i = arr.length - 1; i >= 0; --i)
    	{
    		if (arr[i] < i * 2) // not maxed
    		{
    			++arr[i];
    			
    			// promote any trailing values
    			for (int j = i + 1; j < arr.length; ++j)
    			{
    				arr[j] = arr[j - 1] + 1; // 
    			}
    			
    			return;
    		}
    		// else, arr[i] is maxed, so check the next index in
    	}
    	
    	// if you're here, array is maxed out! set the initial index to 1 as a flag
    	arr[0] = 1;	
    }
}