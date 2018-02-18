package com.plaidman1701.leetcode.problem049;

/*
https://leetcode.com/problems/group-anagrams/description/

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.

*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem049 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] wordArray = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };

		Solution soln = new Solution();

		printArray(soln.groupAnagrams(wordArray));

	}

	private static void printArray(List<List<String>> toPrint) {
		for (List<String> subList : toPrint) {
			for (String word : subList) {
				System.out.print("word:" + word + " ");
			}
			System.out.println();

		}
	}

}

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		
		List<List<String>> returnList = new ArrayList<List<String>>();

		int[] scannedWordsIndexes = new int[strs.length];
		
		String[] wordArray = strs.clone(); // we're gonna mess with the values, so make a copy
		
		// sort the values
		for (int i = 0; i < wordArray.length; ++i)
		{
			char[] cArray = wordArray[i].toCharArray();
			Arrays.sort(cArray);
			wordArray[i] = String.valueOf(cArray);
		}
		
		for (int i = 0; i < wordArray.length; ++i)
		{
			if (scannedWordsIndexes[i] != 0)
			{
				continue;
			}
			
			List<String> wordsAnagrams = new ArrayList<String>();
			wordsAnagrams.add(strs[i]); // add unmodified value
			
			// check each following word
			for (int j = i + 1; j < wordArray.length; ++j)
			{
				if (wordArray[i].equals(wordArray[j]))
				{
					wordsAnagrams.add(strs[j]);
					scannedWordsIndexes[j] = 1;
				}
			}
			
			returnList.add(wordsAnagrams);
			
		}

		return returnList;

	}

}