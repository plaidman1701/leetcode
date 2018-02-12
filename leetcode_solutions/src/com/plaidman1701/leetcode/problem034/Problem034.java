package com.plaidman1701.leetcode.problem034;

/*
https://leetcode.com/problems/search-for-a-range/description/

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

*/

public class Problem034 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		int[] nums = new int[] {5, 7, 7, 8, 8, 10};
		
		printArray(soln.searchRange(nums, 6));
		

	}
	
	private static void printArray(int[] arr)
	{
		for (int i : arr)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}

}

class Solution {
    public int[] searchRange(int[] nums, int target) {
    	// easy out-of-range check
    	if ((nums.length == 0) || (target < nums[0]) || (nums[nums.length - 1] < target))
    	{
    		return new int[] {-1, -1};
    	}
    	
    	return new int[] {
    			findFirst(nums, target, 0, (nums.length - 1)),
    			findLast(nums, target, 0, (nums.length - 1))
    			};
    }
    
    private int findFirst(int[] nums, int target, int startIndex, int endIndex)
    {
    	if (startIndex == endIndex)
    	{
    		if (nums[startIndex] == target)
    		{
    			return startIndex;
    		}
    		else
    		{
    			return -1;
    		}
    	}
    	
    	int workingSize = (endIndex - startIndex) / 2;
    	
    	// find side where FIRST occurrence might be
    	if ((nums[0] <= target) && (target <= nums[startIndex + workingSize])) // check LEFT-most first
    	{
    		return findFirst(nums, target, startIndex, (startIndex + workingSize));
    	}
    	else
    	{
    		return findFirst(nums, target, (startIndex + workingSize + 1), endIndex);
    	}
    }
    
    private int findLast(int[] nums, int target, int startIndex, int endIndex)
    {
    	if (startIndex == endIndex)
    	{
    		if (nums[startIndex] == target)
    		{
    			return startIndex;
    		}
    		else
    		{
    			return -1;
    		}
    	}
    	
    	int workingSize = (endIndex - startIndex) / 2;
    	
    	// find side where LAST occurrence might be
    	if ((nums[startIndex + workingSize + 1] <= target) && (target <= nums[endIndex])) // check RIGHT-most first
    	{
    		return findLast(nums, target, (startIndex + workingSize + 1), endIndex);
    	}
    	else
    	{
    		return findLast(nums, target, startIndex, (startIndex + workingSize));
    	}
    }
}