package com.plaidman1701.leetcode.problem001;

/*
 * https://leetcode.com/problems/two-sum/description/ 
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

public class Problem001 {

	public static void main(String[] args) {
		
		int[] nums = {2, 7, 11, 15};
		Solution soln = new Solution();
		
		int[] ans = soln.twoSum(nums, 22);

		System.out.println(ans[0] + " " + ans[1]);
	}

}
class Solution {
    public int[] twoSum(int[] nums, int target) {
    	
    	int[] returnArray = new int[2];
    	for (int i = 0; i < nums.length - 1; ++i)
    	{
    		for (int j = i+1; j < nums.length; ++j)
    		{
    			System.out.println("i:" + i + " j:" + j);
    			if (nums[i] + nums[j] == target)
    			{
    				returnArray[0] = i;
    				returnArray[1] = j;
    				return returnArray;
    			}
    		}
    	}
    	
    	return returnArray;
        
    }
}


