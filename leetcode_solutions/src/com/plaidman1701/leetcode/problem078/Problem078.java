package com.plaidman1701.leetcode.problem078;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/subsets/description/

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Problem078 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		int[] nums = new int[] {1, 2, 3, 4};
		
		printLists(soln.subsets(nums));

	}

	private static void printLists(List<List<Integer>> toPrint)
	{
		for (List<Integer> l : toPrint)
		{
			for (int i : l)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}

class Solution {
	
	private List<List<Integer>> returnList = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> subsets(int[] nums) {
    	
    	returnList.add(new ArrayList<Integer>()); // add empty list
    	genList(new ArrayList<Integer>(), 0, nums);
    	return returnList; 
    }
    
    private void genList(List<Integer> workingList, int startIndex, int[] nums)
    {
    	for (int i = startIndex; i < nums.length; ++i)
    	{
    		List<Integer> newList = new ArrayList(workingList);
    		newList.add(nums[i]);
    		returnList.add(newList);
    		
    		genList(newList, i + 1, nums);
    	}
    }
}