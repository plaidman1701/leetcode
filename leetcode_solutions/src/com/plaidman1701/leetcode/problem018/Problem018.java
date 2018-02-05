package com.plaidman1701.leetcode.problem018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/4sum/description/

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/

public class Problem018 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		


	}

}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	
    	Set<List<Integer>> returnSet = new HashSet();
    	
    	Arrays.sort(nums); // nLogn
    	
    	int i = 0;
    	
    	while (i < nums.length - 3)
    	{
    		int middlePos = i + 2;
    		while (middlePos < nums.length - 1)
    		{
        		int leftPos = middlePos - 1;
        		int rightPos = middlePos + 1;
        		
        		while (leftPos > i && rightPos < nums.length)
        		{
        			long total = nums[i] + nums[leftPos] + nums[middlePos] + nums[rightPos];
    				if (total == target)
    				{
    					returnSet.add(Arrays.asList(nums[i], nums[leftPos], nums[middlePos], nums[rightPos]));
    					
    					// push both
    					leftPos = pushLeft(nums, leftPos, i);
    					rightPos = pushRight(nums, rightPos);

    				}
    				else if (total <= target)
    				{
    					// push rightPos
    					rightPos = pushRight(nums, rightPos);
    				}
    				else
    				{
    					// push leftPos
    					leftPos = pushLeft(nums, leftPos, i);

    				}
        		}
        		
        		++middlePos;
    		}
    		
    		// push i to next unique value
    		do
    		{
    			++i;
    		}
    		while ((i < nums.length) && (nums[i] == nums[i - 1]));
    	}
    	
    	
    	List<List<Integer>> returnList = new ArrayList(returnSet);
    	return returnList;
    }
    
    private int pushLeft(int[] nums, int leftPos, int i)
    {
    	do
    	{
    		--leftPos;
    	}
    	while (leftPos > i && nums[leftPos] == nums[leftPos + 1]);
    	    	
    	return leftPos;
    }
    
    private int pushRight(int[] nums, int rightPos)
    {
    	do
    	{
    		++rightPos;
    	}
    	while (rightPos < nums.length && nums[rightPos] == nums[rightPos - 1]);
    	
    	return rightPos;
    }
}