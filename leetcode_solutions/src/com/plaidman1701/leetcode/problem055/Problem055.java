package com.plaidman1701.leetcode.problem055;

/*
 https://leetcode.com/problems/jump-game/description/
 
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 
 */
public class Problem055 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		int[] nums = new int[] {2, 3, 1, 1, 4};
		int[] nums2 = new int[] {3, 2, 1, 0, 4};
		
		System.out.println(soln.canJump(nums2));

	}

}

class Solution {
    public boolean canJump(int[] nums) {
    	
    	long furthest = 0; // as far as we can reach
    	
    	for (int i = 0; i < nums.length - 1; ++i)// check all but the last value
    	{
    		furthest = Math.max(furthest, i + nums[i]);
    		
    		if (furthest == i)// i is as far as we can go
    		{
    			return false;
    		}
    		
    		if (furthest >= nums.length - 1) // short-circuit
    		{
    			break;
    		}
    	}
    	
    	return true;
    }
}