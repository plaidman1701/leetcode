package com.plaidman1701.leetcode.problem059;
/*
https://leetcode.com/problems/spiral-matrix-ii/description/

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class Problem059 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		printSquare(soln.generateMatrix(5));

	}
	
	private static void printSquare(int[][] square)
	{
		for (int i = 0; i < square.length; ++i)
		{
			for (int j = 0; j < square[0].length; ++j)
			{
				System.out.print(square[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}


class Solution {
    public int[][] generateMatrix(int n) {
    	
    	int[][] matrix = new int[n][n];
    	
    	if (n == 0)
    	{
    		return matrix;
    	}
    	
    	int counter = 1;
    	matrix[0][0] = counter;
    	
    	if (n == 1)
    	{
    		return matrix;
    	}
    	// simple cases done
    	
    	int i = 0;
    	int j = 0;
    	
    	while(counter < n * n)
    	{
        	// go right
        	while ((j + 1 < n) && (matrix[i][j + 1] == 0))
        	{
        		matrix[i][++j] = ++counter;
        		
        	}
        	
        	// go down
        	while ((i + 1 < n) && (matrix[i + 1][j] == 0))
        	{
        		matrix[++i][j] = ++counter;
        	}
        	
        	// go left
        	while ((j > 0) && (matrix[i][j - 1] == 0))
        	{
        		matrix[i][--j] = ++counter;
        	}
        	
        	// go up
        	while ((i > 0) && (matrix[i - 1][j] == 0))
        	{
        		matrix[--i][j] = ++counter;
        	}
    	}
    	
        return matrix;
    }
}