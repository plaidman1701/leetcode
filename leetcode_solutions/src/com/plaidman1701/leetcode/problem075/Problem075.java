package com.plaidman1701.leetcode.problem075;
/*
https://leetcode.com/problems/sort-colors/description/

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/
public class Problem075 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		int[] nums = new int[] {0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2};
		
		printArr(nums);
		soln.sortColors(nums);
		printArr(nums);

	}
	
	private static void printArr(int[] nums)
	{
		for (int i : nums)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}

}

class Solution {
    public void sortColors(int[] nums) {
    	
    	if (nums.length < 2)
    	{
    		return;
    	}
        
    	int end0 = -1; // index of last 0
    	int end1 = -1; // index of last 1
    	
    	for (int i = 0; i < nums.length; ++i)
    	{
    		switch (nums[i])
    		{
    		case 0:
    			++end0;
    			++end1;
    			nums[end0] = 0;
    			
    			if (end0 < end1) // at least a single 1
    			{
    				nums[end1] = 1;
    			}
    			if (end1 < i) // there's at least a single 2
    			{
    				nums[i] = 2;
    			}
    			
    			break;
    		case 1:
    			++end1;
    			nums[end1] = 1;
    			if (end1 < i) // there's at least a single 2
    			{
    				nums[i] = 2;
    			}
    			break;
    		case 2: // do nothing
    		default:
    			break;
    		}
    	}
    	
    }
}