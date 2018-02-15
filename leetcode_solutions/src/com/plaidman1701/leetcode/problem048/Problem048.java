package com.plaidman1701.leetcode.problem048;

/*
https://leetcode.com/problems/rotate-image/description/

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

*/

public class Problem048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix = new int[][] {
			{5, 1, 9, 11},
			{2, 4, 8, 10},
			{13, 3, 6, 7},
			{15, 14, 12, 16}
		};
		
		printBox(matrix);
		
		Solution soln = new Solution();
		soln.rotate(matrix);
		
		printBox(matrix);
		

	}
	
	private static void printBox(int[][] matrix)
	{
		for (int[] line : matrix)
		{
			for (int i : line)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

class Solution {
    public void rotate(int[][] matrix) {
    	
    	for (int i = 0; i < matrix.length / 2; ++i) // levels into the middle
    	{    		
    		for (int j = i; j < matrix.length - 1 - i; ++j) // don't do the WHOLE line, leave the last corner
    		{
    			// swap 4 sides
    			
    			// top to right
    	    	int tempInt1 = matrix[j][matrix.length - 1 - i];    	    	
    	    	matrix[j][matrix.length - 1 - i] = matrix[i][j];
    	    	
    	    	// right to bottom
    	    	int tempInt2 = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
    	    	matrix[matrix.length - 1 - i][matrix.length - 1 - j] = tempInt1; // tempInt1 free
    	    	
    	    	// bottom to left
    	    	tempInt1 = matrix[matrix.length - 1 - j][i];
    	    	matrix[matrix.length - 1 - j][i] = tempInt2; // tempInt2 free
    	    	
    	    	// left to top
    	    	matrix[i][j] = tempInt1;   	    	
    		}
    	}
        
    }
}
