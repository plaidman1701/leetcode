package com.plaidman1701.leetcode.problem054;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
https://leetcode.com/problems/spiral-matrix/description/

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

*/

public class Problem054 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		int[][] matrix = new int[][] {
			{ 1,  2,  3},
			{ 4,  5,  6},
			{ 7,  8,  9},
			{10, 11, 12},
			{13, 14, 15},
			{16, 17, 18}
			};
		
		printList(soln.spiralOrder(matrix));
		
		

	}
	
	private static void printList(List<Integer> toPrint)
	{
		for (int i : toPrint)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}

}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	
    	List<Integer> returnList = new ArrayList<Integer>();
    	
    	// quick check
    	if ((matrix.length == 0) || (matrix[0].length == 0))
    	{
    		return returnList;
    	}
    	
    	int levels = Math.min(matrix.length, matrix[0].length);
    	
    	int topLevels = (levels / 2) + (levels % 2);
    	int bottomLevels = (levels / 2);
    	    	
    	// values going right and down, we add to a queue
    	// values going left and up, we add to a stack
    	// then we pull the values out in order
    	Queue<Integer>[] topQueues = new LinkedList[topLevels];
    	Stack<Integer>[] bottomStacks = new Stack[bottomLevels];
    	
    	// initialize
    	for (int i = 0; i < bottomLevels; ++i)
    	{
    		topQueues[i] = new LinkedList<Integer>();
    		bottomStacks[i] = new Stack<Integer>();
    	}
    	if (topLevels > bottomLevels) // get the last top
    	{
    		topQueues[topLevels - 1] = new LinkedList<Integer>();
    	}
    	
    	for (int i = 0; i < matrix.length; ++i)
    	{
    		// we check for levels BEFORE the loops, to save checks
			if (i < topLevels) // in the top
			{
				int j = 0;
				while (j < i)
				{
					bottomStacks[j].push(matrix[i][j]);
					++j;
				}
				while (j < matrix[i].length - i)
				{
					topQueues[i].offer(matrix[i][j]);
					++j;
				}
				while (j < matrix[i].length)
				{
					topQueues[matrix[i].length - 1 - j].offer(matrix[i][j]);
					++j;
				}

			}
			else if (i > matrix.length - 1 - bottomLevels) // in the bottom
			{
				int j = 0;
				int verts = matrix.length - 1 - i;
				while (j < verts)
				{
					bottomStacks[j].push(matrix[i][j]);
					++j;
				}
				while (j < matrix[i].length - verts)
				{
					bottomStacks[verts].push(matrix[i][j]);
					++j;
				}
				while (j < matrix[i].length)
				{
					topQueues[matrix[i].length - 1 - j].offer(matrix[i][j]);
					++j;
				}
			}
			else // in the middle, no horizontal lines
			{
				int j = 0;
				for (Stack s : bottomStacks)
				{
					s.push(matrix[i][j]);
					++j;
				}
				
				for (int k = topQueues.length - 1; k >= 0; --k)
				{
					topQueues[k].offer(matrix[i][j]);
					++j;
				}
			}
    	}
    	
    	
    	
    	// build returnList
    	for (int i = 0; i < bottomLevels; ++i)
    	{
    		while (!topQueues[i].isEmpty())
    		{
    			returnList.add(topQueues[i].poll());
    		}
    		
    		while (!bottomStacks[i].empty())
    		{
    			returnList.add(bottomStacks[i].pop());		
    		}
    	}
    	if (topLevels > bottomLevels) // get the last top
    	{
    		while (!topQueues[topLevels - 1].isEmpty())
    		{
    			returnList.add(topQueues[topLevels - 1].poll());
    		}
    	}
    	
		return returnList;
        
    }
}