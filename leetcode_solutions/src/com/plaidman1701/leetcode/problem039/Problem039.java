package com.plaidman1701.leetcode.problem039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/description/

Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]


*/

public class Problem039 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] candidates = {1, 2, 3, 6, 7};
		
		Solution soln = new Solution();
		printList(soln.combinationSum(candidates, 9));

	}
	
	private static void printList(List<List<Integer>> listToPrint)
	{
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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	
    	Arrays.sort(candidates);

    	// least number of values needed
    	int fewestNums = (int)Math.ceil( (double)target / candidates[candidates.length - 1] );
    	
    	// most digits possible
    	int maxNums = target / candidates[0];
    	
    	int workingNums = fewestNums;
    	
    	List<List<Integer>> returnList = new ArrayList<List<Integer>>();
    	
    	while (workingNums <= maxNums)
    	{
    		int[] arrayIndexes = new int[workingNums]; // default at lowest index, 0
    		do
    		{
    			int tempSum = sumArray(arrayIndexes, candidates);
    			if (tempSum == target)
    			{
    				returnList.add(buildIntegerList(arrayIndexes, candidates));
    			}
    			else if (tempSum > target)
    			{
    				overloadArray(arrayIndexes, candidates, target);
    			}
    		}
    		while(incrementArray(arrayIndexes, candidates.length - 1));
    		
    		++workingNums;
    	}    	
    	return returnList;
    }
    
    private int sumArray(int[] arrayIndexes, int[] candidates)
    {
    	int returnInt = 0;
    	for (int i : arrayIndexes)
    	{
    		returnInt += candidates[i];
    	}
    	return returnInt;
    }
    
    // promotes the array from the end-forward; no index can have a value lower than its predecessors
    // returns true if array was incremented, false if it was maxed out
    private boolean incrementArray(int[] arrayIndexes, int maxIndexValue)
    {
    	// if array full
    	if ((arrayIndexes[0] == maxIndexValue) && arrayIndexes[arrayIndexes.length - 1] == maxIndexValue)
    	{
    		return false;
    	}
    	
    	if (arrayIndexes[arrayIndexes.length - 1] < maxIndexValue)
    	{
    		++arrayIndexes[arrayIndexes.length - 1];
    		return true;
    	}
    	
    	// at this point, last value is maxed out but there's still room to promote
    	// gotta find the last max-indexed value and promote it and its followers
    	
    	int trailingIndex = arrayIndexes.length - 1;
    	
    	while (arrayIndexes[trailingIndex] == maxIndexValue)
    	{
    		--trailingIndex;
    	}
    	
    	++arrayIndexes[trailingIndex];
    	for (int i = trailingIndex + 1; i < arrayIndexes.length; ++i)
    	{
    		arrayIndexes[i] = arrayIndexes[trailingIndex];
    	}
    	
    	return true;
    }
    
    private List<Integer> buildIntegerList(int[] arrayIndexes, int[] candidates)
    {
    	List<Integer> returnList = new ArrayList<Integer>();
    	
    	for (int i : arrayIndexes)
    	{
    		returnList.add(candidates[i]);
    	}
    	
    	return returnList;
    }
    
    // to be used when the array sum exceeds the target and we know there's no reason
    // to scan the rest of this column at this value. maxes out current and following columns
    // so the incrementer will look at the preceding column.
    private void overloadArray(int[] arrayIndexes, int[] candidates, int target)
    {
    	int i = 0;
    	int tempSum = candidates[arrayIndexes[i]];

    	while(tempSum < target)
    	{
    		++i;
    		tempSum += candidates[arrayIndexes[i]];
    	}
    	
    	arrayIndexes[i] = candidates.length - 1;
    	++i;
    	
    	for (; i < arrayIndexes.length; ++i)
    	{
    		arrayIndexes[i] = arrayIndexes[i - 1];
    	}
    }

}


