package com.plaidman1701.leetcode.problem016;

import java.util.Arrays;

/*
https://leetcode.com/problems/3sum-closest/description/

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


*/

public class Problem016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution soln = new Solution();
		
		int[] myArray = new int[] {1,1,-1,-1,3};

		System.out.println(soln.threeSumClosest(myArray, -1));
	}
	


}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
    	
    	if (nums.length < 3)
    	{
    		return 0;
    	}
    	
    	// set return
    	int returnInt = (target > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE);
    	    	
    	Arrays.sort(nums); // nLogn
    	
    	int i = 1; // initial start at 2nd pos
    	
    	while (i < nums.length - 1 && returnInt != target)
    	{
    		int leftPos = i - 1;
    		int rightPos = i + 1;
    		
    		while (leftPos >= 0 && rightPos < nums.length)
    		{
    			
        		long total = nums[leftPos] + nums[i] + nums[rightPos];
        		long diff = target - total;

        		returnInt = (int) ((Math.abs(diff) < Math.abs((long)returnInt - target)) ? total : returnInt );        		
        		
        		if (diff == 0)
        		{
        			return returnInt;
        		}
        		else if (diff < 0)
        		{
        			--leftPos;
        		}
        		else
        		{
        			++rightPos;
        		}
    		}
    	
    		++i;
    	}
    	
    	return returnInt;
    }
}