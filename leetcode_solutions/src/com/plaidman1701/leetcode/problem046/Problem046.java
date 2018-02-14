package com.plaidman1701.leetcode.problem046;

/*
https://leetcode.com/problems/permutations/description/

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem046 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		int[] nums = new int[] {1, 2, 3, 4};
		
		printList(soln.permute(nums));

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
	
    public List<List<Integer>> permute(int[] nums) {
    	
    	List<Integer> workingList = new ArrayList<Integer>();
    	
    	for (int i = 0; i < nums.length; ++i)
    	{
    		workingList.add(nums[i]);
    	}
    	
    	recursiveArray(0, workingList);
    	
    	return returnList;
        
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
    	
    	// swap index for each following value
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
    
    private List<List<Integer>> getList()
    {
    	return returnList;
    }
}