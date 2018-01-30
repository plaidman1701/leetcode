package com.plaidman1701.leetcode.problem003;

/*

https://leetcode.com/problems/longest-substring-without-repeating-characters/
	
Given a string, find the length of the longest substring without repeating characters.

*/
import java.util.HashMap;
import java.util.Map;

public class Problem003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("prob 3");
		
		Solution soln = new Solution();
		
		System.out.println(soln.lengthOfLongestSubstring("abcdebfaf"));
	}
}

class Solution {
	public int lengthOfLongestSubstring(String s) {

		int startIndex = 0;
		int workingLength = 0;
		int maxLength = 0;

		Map<Character, Integer> alphabet = new HashMap<Character, Integer>();

		while ((startIndex + workingLength) < s.length())
		{
			for (int i = startIndex + workingLength; i < s.length(); ++i)
			{
				char tempChar = s.charAt(i);
				
				//System.out.print ("i:" + i + " tempChar:" + tempChar);
				
				Integer lastTime = alphabet.get(tempChar);
				alphabet.put(tempChar, i);
				
				if ((lastTime == null) || (lastTime < startIndex))						
				{
					++workingLength;
					if (workingLength > maxLength)
					{
						maxLength = workingLength;
					}
					
					//System.out.println(" working:" + workingLength + " max:" + maxLength);
				}
				else if (lastTime >= startIndex) // seen since index began!
				{
					startIndex = lastTime + 1; // move 1 over
					workingLength = i - lastTime;
					//System.out.println(" foundMatch new startIndex:" + startIndex + " workingLength:" + workingLength);
					break; // end loop
				}				
			}

		}
		
		return maxLength;
	}
}