package com.plaidman1701.leetcode.problem077;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/combinations/description/

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/
public class Problem077 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		printLists(soln.combine(4, 3));
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
	
	List<List<Integer>> returnList = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> combine(int n, int k) {
    	
    	buildList(1, n, k, new ArrayList<Integer>());
    	return returnList;
    }
    
    private void buildList(int startValue, int endValue, int digitsRemaining, List<Integer> workingList)
    {
    	for (int i = startValue; i <= endValue - digitsRemaining + 1; ++i)
    	{
    		List<Integer> newList = new ArrayList(workingList);
    		newList.add(i);
    		
    		if (digitsRemaining == 1)
    		{
    			returnList.add(newList);
    		}
    		else
    		{
    			buildList(i + 1, endValue, digitsRemaining - 1, newList);
    		}
    	}
    }
    
    private void addList(List<Integer> listToAdd)
    {
    	returnList.add(listToAdd);
    }
}