package com.plaidman1701.leetcode.problem006;

/*
 
https://leetcode.com/problems/zigzag-conversion/description/

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

*/

public class Problem006 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		System.out.println(soln.convert("PAYPALISHIRING", 3));

	}

}


class Solution {
    public String convert(String s, int numRows) {
    	
    	if (numRows == 1)
    	{
    		return s;
    	}
    	
    	StringBuilder[] levels = new StringBuilder[numRows];
    	
    	for (int i = 0; i < numRows; ++i)
    	{
    		levels[i] = new StringBuilder();
    	}
    	
    	StringBuilder outputString = new StringBuilder();
    	
    	int j = 0;
    	for (int i = 0; i < s.length(); ++i)
    	{
    		System.out.println("start loop. j:" + j);
    		
    		levels[j].append(s.charAt(i));
    		    		
    		if (((i / (numRows - 1)) % 2 ) == 0)
    		{
    			++j;
    		}
    		else
    		{
    			--j;
    		}   		
    	}
    	
    	for (int i = 0; i < numRows; ++i)
    	{
    		outputString.append(levels[i].toString());
    	}
    	
    	return outputString.toString();
        
    }
}
