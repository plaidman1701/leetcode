package com.plaidman1701.leetcode.problem062;
/*
https://leetcode.com/problems/unique-paths/description/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

https://leetcode.com/static/images/problemset/robot_maze.png
Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

*/
public class Problem062 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		System.out.println(soln.uniquePaths(100, 100));
		

	}

}
/*
A better idea would be to just calculate the raw permutations (m + n)! / (m! * n!)
 
 */
class Solution {
    public int uniquePaths(int m, int n) {
    	
    	// quick edge cases
    	if (m < 1 || n < 1)
    	{
    		return 0;
    	}
    	
    	if (m == 1 || n == 1)
    	{
    		return 1;    		
    	}
    	
    	if (m == 2 || n == 2)
    	{
    		return Math.max(m, n);
    	}
    	
    	int smallerAxis;
    	int largerAxis;
    	
    	if (m > n)
    	{
    		smallerAxis = n;
    		largerAxis = m;
    	}
    	else
    	{
    		smallerAxis = m;
    		largerAxis = n;
    	}
    	
    	
    	long[][] matrix = new long[smallerAxis][largerAxis];
    	
    	// set 1's along the top
    	for (int i = 0; i < largerAxis; ++i)
    	{
    		matrix[0][i] = 1;
    	}
    	// set values. try to save some time by not filling in the dupe values
    	for (int i = 1; i < smallerAxis; ++i)
    	{
    		for (int j = i; j < largerAxis; ++j)
    		{
    			if (i == j)
    			{
    				matrix[i][j] = matrix[i - 1][j] * 2;
    			}
    			else
    			{
    				matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
    			}
    		}
    	}
    	
    	return (matrix[smallerAxis - 1][largerAxis - 1] > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)matrix[smallerAxis - 1][largerAxis - 1]);
        
    }
}