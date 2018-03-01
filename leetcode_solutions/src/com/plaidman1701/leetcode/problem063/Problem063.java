package com.plaidman1701.leetcode.problem063;
/*
https://leetcode.com/problems/unique-paths-ii/description/

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/
public class Problem063 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] obstacleGrid = new int[][] {
			{0, 0, 0},
			{0, 1, 0},
			{0, 0, 0}
		};
		
		Solution soln = new Solution();
		
		
		System.out.println(soln.uniquePathsWithObstacles(obstacleGrid));

	}

}
// could also just store 1 row instead of re-writing thr whole grid
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	
    	if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1)
    	{
    		return 0;
    	}
    	    	
    	// set initial 1's and check for 1 x array
    	obstacleGrid[0][0] = 1;
    	
    	//printGrid(obstacleGrid);
    	
    	
    	boolean initFailed = false;
    	for (int i = 1; i < obstacleGrid[0].length; ++i)
    	{
    		if (obstacleGrid[0][i] == 0)
    		{
    			obstacleGrid[0][i] = obstacleGrid[0][i - 1];
    		}
    		else
    		{
    			obstacleGrid[0][i] = 0;
    			initFailed = true;
    		}
    	}
    	
    	for (int i = 1; i < obstacleGrid.length; ++i)
    	{
    		if (obstacleGrid[i][0] == 0)
    		{
    			obstacleGrid[i][0] = obstacleGrid[i - 1][0];
    		}
    		else
    		{
    			obstacleGrid[i][0] = 0;
    			initFailed = true;
    		}
    	}
    	
    	if (obstacleGrid.length == 1 || obstacleGrid[0].length == 1)
    	{
    		return (initFailed ? 0 : 1);
    	}
    	
    	for (int i = 1; i < obstacleGrid.length; ++i)
    	{
    		for (int j = 1; j < obstacleGrid[0].length; ++j)
    		{
    			if (obstacleGrid[i][j] == 0)
    			{
    				obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
    			}
    			else
    			{
    				obstacleGrid[i][j] = 0;
    			}
    		}
    	}
    	
    	//printGrid(obstacleGrid);
    	
    	return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        
    }
    
    private void printGrid(int[][] grid)
    {
    	for (int i = 0; i < grid.length; ++i)
    	{
    		for (int j = 0; j < grid[0].length; ++j)
    		{
    			System.out.print(grid[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}