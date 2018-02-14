package com.plaidman1701.leetcode.problem047;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/permutations-ii/description/

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/
public class Problem047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		int[] nums = new int[] {1, 1, 2};
		
		printList(soln.permuteUnique(nums));

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
	
	List<List<Integer>> returnList = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	
    	List<Integer> workingList = new ArrayList<Integer>();
    	
    	for (int i = 0; i < nums.length; ++i)
    	{
    		workingList.add(nums[i]);
    	}
    	
    	recursiveArray(0, workingList);
    	
    	return getList();
    }
    
    private void recursiveArray(int index, List<Integer> workingList)
    {
    	if (index == workingList.size() - 1) // at last index, nothing left to sort
    	{
    		addList(workingList);
    		return;
    	}
    	    	
    	// first one, as is, then...
    	recursiveArray(index + 1, workingList);
    	
    	// ... swap index for each following value
    	for (int i = 1; i < workingList.size() - index; ++i)
    	{
    		List<Integer> tempList = new ArrayList<Integer>(workingList);
    		Collections.swap(tempList, index, index + i);
    		recursiveArray(index + 1, tempList);
    	}	
    }
    
    private void addList(List<Integer> workingList)
    {
    	returnList.add(workingList);
    }
    
    // this is a bit of a cheat, we're burning a lot of time but it's simple to understand
    private List<List<Integer>> getList()
    {
    	Set<List<Integer>> hs = new HashSet();
    	hs.addAll(returnList);
    	returnList.clear();
    	returnList.addAll(hs);
    	
    	return returnList;
    }
}