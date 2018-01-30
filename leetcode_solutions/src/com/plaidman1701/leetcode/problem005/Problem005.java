package com.plaidman1701.leetcode.problem005;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */


public class Problem005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution soln = new Solution();

		System.out.println(soln.longestPalindrome("granutforajaroftunauk")); // longest
																				// palindrome:
																				// anutforajaroftuna
		//System.out.println(soln.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
}

class Solution {
	public String longestPalindrome(String s) {

		String longestSub = "";
		
		int oddlength = 0;
		int evenlength = 0;

		for (int i = 0; i < s.length(); ++i) {
			
			// break if past halfway point and max possible already found
			if (s.length() - i < longestSub.length() / 2)
			{
				break;
			}
						
			// odd-numbered lengths
			oddlength = checkSubstring(s, i, i);
			
			// even-numbered lengths
			evenlength = checkSubstring(s, i, i + 1);
						
			if (Math.max(oddlength, evenlength) > longestSub.length())
			{
				int startIndex = (oddlength >= evenlength ? i - (oddlength / 2) : i - (evenlength / 2) + 1);
				
				longestSub = s.substring(startIndex, startIndex + Math.max(oddlength, evenlength));
			}
		}

		return longestSub;
	}

	private int checkSubstring(String s, int startPos, int endPos) {

		while (startPos >= 0 && endPos < s.length() && (s.charAt(startPos) == s.charAt(endPos)))
		{
			--startPos;
			++endPos;
		}
		
		return (endPos - startPos - 2 + 1);

	}

}
