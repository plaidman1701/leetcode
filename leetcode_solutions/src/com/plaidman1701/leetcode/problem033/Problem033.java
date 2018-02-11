package com.plaidman1701.leetcode.problem033;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array/description/

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

*/

public class Problem033 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		int[] nums = new int[] {4, 5, 6, 7, 10, 12, 15, 16, 20, 34, -4,-3, -1, 0, 1, 2};
		
		System.out.println(soln.search(nums, -3));

	}

}


class Solution {
    public int search(int[] nums, int target) {
    	
    	if (nums.length == 0)
    	{
    		return -1;
    	}
    	
    	return divideArray(nums, target, 0, nums.length - 1);
        
    }
    
    private int divideArray(int[] nums, int target, int startIndex, int endIndex)
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
    	
    	boolean checkLeft; // true if the left side should be checked, otherwise check right
    	
    	// find side where target is
    	if (nums[startIndex] <= nums[startIndex + workingSize]) // leftside is sorted
    	{
    		if ((nums[startIndex] <= target) && (target <= nums[startIndex + workingSize])) // leftside contains target
    		{
    			checkLeft = true;
    		}
    		else // unsorted rightside contains target
    		{
    			checkLeft = false;
    		}
    	}
    	else // rightside is sorted
    	{
    		if ((nums[startIndex + workingSize + 1] <= target) && (target <= nums[endIndex])) // rightside contains target
    		{
    			checkLeft = false;
    		}
    		else // unsorted leftside contains target
    		{
    			checkLeft = true;
    		}
    	}
    	
    	if (checkLeft)
    	{
    		endIndex = startIndex + workingSize;
    	}
    	else
    	{
    		startIndex = startIndex + workingSize + 1;
    	}
    	
    	return divideArray(nums, target, startIndex, endIndex);
    }
}