package com.plaidman1701.leetcode.problem017;

import java.util.ArrayList;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem017 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {
	
	private static final Map<Character, char[]> keypad = new HashMap<>();
	
	static {
		keypad.put('0', new char[] {});
		keypad.put('1', new char[] {});
		keypad.put('2', new char[] {'a', 'b', 'c'});
		keypad.put('3', new char[] {'d', 'e', 'f'});
		keypad.put('4', new char[] {'g', 'h', 'i'});
		keypad.put('5', new char[] {'j', 'k', 'l'});
		keypad.put('6', new char[] {'m', 'n', 'o'});
		keypad.put('7', new char[] {'p', 'q', 'r', 's'});
		keypad.put('8', new char[] {'t', 'u', 'v'});
		keypad.put('9', new char[] {'w', 'x', 'y', 'z'});
	}
	
	
    public List<String> letterCombinations(String digits) {
    	
    	List<String> returnList = new ArrayList<String>();
    	
    	if (digits.length() == 0)
    	{
    		return returnList;
    	}
    	
    	// set first value
    	for (char a : keypad.get(digits.charAt(0)))
    	{
    		returnList.add(Character.toString(a));
    	}
    	
    	if (digits.length() == 1)
    	{
    		return returnList;
    	}
    	
    	for (int i = 1; i < digits.length(); ++i)
    	{
    		List<String> tempList = new ArrayList<String>();
    		
    		for (char letterToAdd : keypad.get(digits.charAt(i)))
    		{
    			for (String stringToAppend : returnList)
    			{
    				tempList.add(stringToAppend + letterToAdd);
    			}
    		}
   
    		returnList = tempList;
    	}

    	return returnList;      
    }
}