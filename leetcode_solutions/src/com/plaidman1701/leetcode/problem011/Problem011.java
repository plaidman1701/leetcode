package com.plaidman1701.leetcode.problem011;

/*
https://leetcode.com/problems/container-with-most-water/description/

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/

public class Problem011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		System.out.println(soln.maxArea(new int[] {2,3,4,5,18,17,6}));

	}

}

class Solution {
    public int maxArea(int[] height) {
    	
    	// converge both indexes on the biggest value (or one of the ties)
    	
    	int i = 0;
    	int j = height.length - 1;
    	
    	int maxVolume = 0;
    	
    	while (i < j) // stop when they cross
    	{
    		
    		int tempVolume = (j - i) * Math.min(height[i], height[j]);
    		maxVolume = Math.max(maxVolume, tempVolume);
    		
    		//System.out.println("i:" + i + "/" + height[i] + " j:" + j + "/" + height[j] + " tempVolume:" + tempVolume);
    		
    		if (height[i] < height[j])
    		{
    			++i;
    		}
    		else
    		{
    			--j;
    		}
    	}
    	
    	return maxVolume;
        
    }
}

