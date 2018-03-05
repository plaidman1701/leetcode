package com.plaidman1701.leetcode.problem073;
/*
https://leetcode.com/problems/set-matrix-zeroes/description/

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/
public class Problem073 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix = new int[][] {
			{6,1,2,6,5,6,2,1,3,8,9,1,9,1,7,2,3},
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
			{1,5,4,4,9,5,1,9,3,6,0,3,3,5,0,4,8}			
		};
		
		printGrid(matrix);
		System.out.println();
		
		Solution soln = new Solution();
		soln.setZeroes(matrix);
		printGrid(matrix);

	}
	
	private static void printGrid(int[][] matrix)
	{
		for (int[] i : matrix)
		{
			for (int j : i)
			{
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}

class Solution {
    public void setZeroes(int[][] matrix) {
    	
    	if ((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0))
    	{
    		return;
    	}
    	
    	// check to see if axis should be zero'd
    	boolean x = false;
    	boolean y = false;
    	
    	for (int i = 0; i < matrix[0].length; ++i)
    	{
    		if (matrix[0][i] == 0)
    		{
        		x = true;
        		break;
    		}
    	}
    	
    	for (int i = 0; i < matrix.length; ++i)
    	{
    		if (matrix[i][0] == 0)
    		{
        		y = true;
        		break;
    		}
    	}
    	
    	// set 0 markers
    	for (int i = 1; i < matrix.length; ++i)
    	{
    		for (int j = 1; j < matrix[i].length; ++j)
    		{
    			if (matrix[i][j] == 0)
    			{
    				matrix[0][j] = 0;
    				matrix[i][0] = 0;
    			}
    		}
    	}
    	
    	// fill 0's
    	for (int i = 1; i < matrix.length; ++i)
    	{
    		if (matrix[i][0] == 0)
    		{
    			for (int j = 1; j < matrix[i].length; ++j)
    			{
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	
    	for (int i = 1; i < matrix[0].length; ++i)
    	{
    		if (matrix[0][i] == 0)
    		{
    			for (int j = 1; j < matrix.length; ++j)
    			{
    				matrix[j][i] = 0;
    			}
    		}
    	}
    	
    	// fill axes
    	if (x)
    	{
    		for (int i = 0; i < matrix[0].length; ++i)
    		{
    			matrix[0][i] = 0;
    		}
    	}
    	
    	if (y)
    	{
    		for (int i = 0; i < matrix.length; ++i)
    		{
    			matrix[i][0] = 0;
    		}
    	}
    }
}