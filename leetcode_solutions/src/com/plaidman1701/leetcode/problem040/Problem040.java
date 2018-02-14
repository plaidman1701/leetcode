package com.plaidman1701.leetcode.problem040;

/*
https://leetcode.com/problems/combination-sum-ii/description/

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem040 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] candidates = new int[] {10,1,2,7,6,1,5};
		
		Solution soln = new Solution();
		printList(soln.combinationSum2(candidates, 8));
		
		//soln.combinationSum2(candidates, 8);

	}
	
	private static void printList(List<List<Integer>> listToPrint)
	{
		System.out.println("final list:");
		for (List<Integer> sublist : listToPrint)
		{
			for (int i : sublist)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}

class Solution {
	
	private List<List<Integer>> returnList = new ArrayList();
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	
    	Arrays.sort(candidates);
    	    	
    	List<Integer> workingList = new ArrayList<Integer>();
    	findElement(candidates, target, candidates.length - 1, workingList);

    	return getList();
    }
    
    // recursively find all combinations on the left-side of the current index for a target value
    private void findElement(int[] candidates, int target, int startIndex, List<Integer> workingList)
    {
    	if (target == 0)
    	{
    		addList(workingList);
    		return;
    	}
    	
    	if (target < 0) // safety
    	{
    		return;
    	}
    	
    	for (int i = startIndex; i >= 0; --i)
    	{
    		if (candidates[i] <= target)
    		{
    			List<Integer> workingList2 = new ArrayList<Integer>(workingList);
    			workingList2.add(candidates[i]);
    			
    			findElement(candidates, target - candidates[i], i - 1, workingList2);
    		}
    	}
    }
    
    private void addList(List<Integer> listToAdd)
    {
    	returnList.add(listToAdd);
    }
    
    // first weeds out the dupes and returns the list
    private List<List<Integer>> getList()
    {
    	Set<List<Integer>> hs = new HashSet();
    	hs.addAll(returnList);
    	returnList.clear();
    	returnList.addAll(hs);
    	
    	return returnList;
    }
}