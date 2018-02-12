package com.plaidman1701.leetcode.problem036;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/valid-sudoku/description/

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

*/
public class Problem036 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		char[][] board = new char[][] {
			{'.','8','7','6','5','4','3','2','1'},
			{'2','.','.','.','.','.','.','.','.'},
			{'3','.','.','.','.','.','.','.','.'},
			{'4','.','.','.','.','.','.','.','.'},
			{'5','.','.','.','.','.','.','.','.'},
			{'6','.','.','.','.','.','.','.','.'},
			{'7','.','.','.','.','.','.','.','.'},
			{'8','.','.','.','.','.','.','.','.'},
			{'9','.','.','.','.','.','.','.','.'}
		};
		
		System.out.println(soln.isValidSudoku(board));
	}

}

class Solution {
    public boolean isValidSudoku(char[][] board) {
    	
    	// let's do this in one pass. O(n) for lyfe.
    	Set[] horizSets = new HashSet[9];
    	Set[] vertSets = new HashSet[9];
    	Set[][] threeByThreeSets = new HashSet[3][3];
    	
    	// initialize!
    	for (int i = 0; i < 9; ++i)
    	{
    		horizSets[i] = new HashSet<Character>();
    		vertSets[i] = new HashSet<Character>();
    		threeByThreeSets[i / 3][i % 3] = new HashSet<Character>();
    	}
    	
    	for (int i = 0; i < 9; ++i)
    	{
    		for (int j = 0; j < 9; ++j)
    		{
    			char c = board[i][j];
    			if (('1' <= c) && (c <= '9')) // c between 1 and 9 inclusive
    			{
    				if (! (horizSets[i].add(c) && vertSets[j].add(c) && threeByThreeSets[i / 3][j / 3].add(c)) )
    				{
    					return false;
    				}
    			}
    		}
    	}
    	
    	return true;
    }
}