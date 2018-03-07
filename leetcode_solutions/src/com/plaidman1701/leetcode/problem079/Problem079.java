package com.plaidman1701.leetcode.problem079;

import java.io.IOException;
import java.util.Arrays;

/*
https://leetcode.com/problems/word-search/description/

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
public class Problem079 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		char[][] board = new char[][] {
			
		
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},
				{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','b'}
			

				};


		Solution soln = new Solution();
		
		String word = "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println("word:" + word.length() + " grid:" + (board.length * board[0].length));
		System.out.println(soln.exist(board, word));

	}

}

class Solution {

	private boolean foundWord = false;

	public boolean exist(char[][] board, String word) {
		// check early edges
		if ((board.length == 0) || (board[0].length == 0)) {
			return false;
		}

		if ((board.length == 1) && (board[0].length == 1)) {
			if ((word.length() == 1) && (word.charAt(0) == board[0][0])) {
				return true;
			}
			return false;
		}

		for (int i = 0; i < board.length && !foundWord; ++i) {
			for (int j = 0; j < board[0].length && !foundWord; ++j) {
				if (board[i][j] == word.charAt(0)) {
					boolean[][] history = new boolean[board.length][board[0].length];
					history[i][j] = true;

					findNextLetter(board, i, j, word.substring(1), history);
				}
			}
		}

		return foundWord;

	}

	private void findNextLetter(char[][] board, int ypos, int xpos, String toFind, boolean[][] history) {
		if ((toFind.length() == 0) || foundWord) {
			foundWord = true;
			return;
		}

		// check each of the 4 directions
		char charToCheck = toFind.charAt(0);

		// check above
		if ((!foundWord) && (ypos - 1 >= 0) && (history[ypos - 1][xpos] == false) && (board[ypos - 1][xpos] == charToCheck))
		{
			if (toFind.length() == 1) {
				foundWord = true;
				return;
			}

			boolean[][] newHistory = copyHistory(history);
			
			newHistory[ypos - 1][xpos] = true;

			findNextLetter(board, ypos - 1, xpos, toFind.substring(1), newHistory);
		}

		// check below
		if ((!foundWord) && (ypos + 1 < board.length) && (history[ypos + 1][xpos] == false) && (board[ypos + 1][xpos] == charToCheck))
		{
			if (toFind.length() == 1) {
				foundWord = true;
				return;
			}

			boolean[][] newHistory = copyHistory(history);
			
			newHistory[ypos + 1][xpos] = true;

			findNextLetter(board, ypos + 1, xpos, toFind.substring(1), newHistory);
		}

		// check left
		if ((!foundWord) && (xpos - 1 >= 0) && (history[ypos][xpos - 1] == false) && (board[ypos][xpos - 1] == charToCheck))
		{
			if (toFind.length() == 1) {
				foundWord = true;
				return;
			}

			boolean[][] newHistory = copyHistory(history);
			
			newHistory[ypos][xpos - 1] = true;

			findNextLetter(board, ypos, xpos - 1, toFind.substring(1), newHistory);
		}

		// check right
		if ((!foundWord) && (xpos + 1 < board[0].length) && (history[ypos][xpos + 1] == false) && (board[ypos][xpos + 1] == charToCheck))
		{
			if (toFind.length() == 1) {
				foundWord = true;
				return;
			}

			boolean[][] newHistory = copyHistory(history);
			
			newHistory[ypos][xpos + 1] = true;

			findNextLetter(board, ypos, xpos + 1, toFind.substring(1), newHistory);
		}
	}
	
	private boolean[][] copyHistory(boolean[][] history)
	{
		boolean[][] newHistory = new boolean[history.length][history[0].length];
		for (int i = 0; i < history.length; ++i)
		{
			newHistory[i] = history[i].clone();
		}
		
		return newHistory;
	}
}