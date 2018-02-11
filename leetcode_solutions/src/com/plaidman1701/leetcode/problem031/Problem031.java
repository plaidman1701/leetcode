package com.plaidman1701.leetcode.problem031;

/*
https://leetcode.com/problems/next-permutation/description/

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 --> 1,3,2
3,2,1 --> 1,2,3
1,1,5 --> 1,5,1

*/

public class Problem031 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] testArray = new int[] {2,2,20,5, 3, 1};
		
		printArray(testArray);
		
		Solution soln = new Solution();
		//soln.nextPermutation(new int[] {1, 3, 2});
		soln.nextPermutation(testArray);
		printArray(testArray);

	}
	
	private static void printArray(int[] arrayToPrint)
	{
		for (int i : arrayToPrint)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}

}

class Solution {
    public void nextPermutation(int[] nums) {
    	
    	if (nums.length < 2)
    	{
    		return;
    	}
    	
    	// find first step-down in value
    	
    	int i = nums.length - 1;
    	
    	while ((i > 0) && (nums[i - 1] >= nums[i]))
    	{
    		--i;
    	}
    	
    	if (i == 0) // no hits
    	{
    		// swap values
    		int tempint;
    		while (i < nums.length / 2)
    		{
    			tempint = nums[i];
    			nums[i] = nums[nums.length - 1 - i];
    			nums[nums.length - 1 - i] = tempint;
    			++i;
    		}
    	}
    	else // found a hit
    	{
    		// find the appropriate value to swap
    		int j = nums.length;
    		do
    		{
    			--j;
    		}
    		while (nums[j] <= nums[i - 1]);

        	int tempint = nums[j];
        	nums[j] = nums[i - 1];
        	nums[i - 1] = tempint;
    		
        	// push remaining smaller values left, starting at i.
        	// just use a bubblesort, since we can't use more memory to build sub-arrays
    		pushleft(nums, i);
    	}
        
    }
    
    private static void pushleft(int[] nums, int j)
    {
    	for (int i = nums.length - 1; i > j; --i)
    	{
    		if (nums[i] < nums[i - 1])
    		{
    			int tempint = nums[i];
    			nums[i] = nums[i - 1];
    			nums[i - 1] = tempint;
    		}
    	}
    	
    	if (j < nums.length - 1)
    	{
    		pushleft(nums, j + 1);
    	}
    }
}