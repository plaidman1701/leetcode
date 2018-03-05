package com.plaidman1701.leetcode.problem064;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import java.util.TreeMap;
import java.util.SortedSet;

/*
https://leetcode.com/problems/minimum-path-sum/description/

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
[[1,3,1],
 [1,5,1],
 [4,2,1]]
Given the above grid map, return 7. Because the path 1->3->1->1->1 minimizes the sum.
*/
public class Problem064 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
/*
	int[][] grid = new int[][]{
			{1,3,1},
			{1,5,1},
			{4,15,1}			
		};
	*/
		
		int[][] grid = new int[][] {
			{6,0,2,6,5,6,2,0,3,8,9,1,9,1,7,2,3},
			{7,3,6,8,4,9,9,1,4,6,4,1,8,3,9,9,6},
			{5,6,4,9,6,7,7,5,0,7,7,9,9,2,7,4,8},
			{7,0,9,6,4,4,2,8,7,3,2,6,4,0,4,0,6},
			{3,8,3,1,4,5,0,3,5,1,5,4,5,6,1,8,7},
			{7,2,1,2,2,8,5,6,7,9,6,1,1,2,4,9,7},
			{7,5,3,7,0,0,8,6,6,6,4,7,4,1,6,8,5},
			{0,0,5,7,7,2,8,3,5,9,8,2,1,5,9,8,0},
			{7,9,0,7,7,8,3,1,5,9,4,4,7,9,6,0,5},
			{4,7,9,2,2,7,4,2,9,7,0,8,5,0,7,4,3},
			{7,1,1,2,4,9,2,9,5,1,8,1,1,5,5,0,7},
			{0,5,4,4,9,5,1,9,3,6,0,3,3,5,0,4,8}			
		};

		System.out.println(soln.minPathSum(grid));

	}

}

class Solution
{
	public int minPathSum(int[][] grid) {
    	if (grid.length == 0 || grid[0].length == 0)
    	{
    		return 0;
    	}
    	
    	// get quick horiz
    	if (grid.length == 1)
    	{
    		long sum = 0;
    		for (int i = 0; i < grid[0].length; ++i)
    		{
    			sum += grid[0][i];
    		}
    		
    		if (sum > Integer.MAX_VALUE)
    		{
    			return Integer.MAX_VALUE;
    		}
    		
    		return (int)sum;
    	}
    	
    	// get quick vert
    	if (grid[0].length == 1)
    	{
    		long sum = 0;
    		for (int i = 0; i < grid.length; ++i)
    		{
    			sum += grid[i][0];
    		}
    		
    		if (sum > Integer.MAX_VALUE)
    		{
    			return Integer.MAX_VALUE;
    		}
    		
    		return (int)sum;
    	}
    	
    	long[] headerArray = new long[grid[0].length];
    	
    	// initialize
    	headerArray[0] = grid[0][0];
    	for (int i = 1; i < grid[0].length; ++i)
    	{
    		headerArray[i] = headerArray[i - 1] + grid[0][i];
    	}
    	
    	for (int i = 1; i < grid.length; ++i)
    	{			
    		for (int j = 0; j < grid[0].length; ++j)
    		{
        		if (j > 0)
        		{
        			headerArray[j] = Math.min(headerArray[j - 1], headerArray[j]) + grid[i][j];
        		}
        		else
        		{
        			headerArray[j] = headerArray[j] + grid[i][j];
        		}
        		
    		}
    	}
    	
    	if (headerArray[headerArray.length - 1] > Integer.MAX_VALUE)
    	{
    		return Integer.MAX_VALUE;
    	}
    	
    	return (int)headerArray[headerArray.length - 1];
    	
	}

}