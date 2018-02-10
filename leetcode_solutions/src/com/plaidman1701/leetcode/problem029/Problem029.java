package com.plaidman1701.leetcode.problem029;


/*
https://leetcode.com/problems/divide-two-integers/description/

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.


*/

public class Problem029 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		//System.out.println(soln.divide(100, -2));
		System.out.println(soln.divide(-2147483648, 3));
		//System.out.println(soln.divide(2147483647, -1));
		//System.out.println();
		//System.out.println(Integer.MIN_VALUE);
		//System.out.println(Integer.MAX_VALUE);
	}

}
class Solution {
    public int divide(int dividend, int divisor) {
    	
    	if (divisor == 0)
    	{
    		return Integer.MAX_VALUE;
    	}
    	
    	if (dividend == 0)
    	{
    		return 0;
    	}
    
    	//basically just recreate long division, for the speed benefit

    	// convert to positive values. Math.abs is too touchy
    	long longTop = dividend;
    	long longBottom = divisor;
    	
    	boolean returnIsPos = true;
    	
    	if (longTop < 0)
    	{
    		longTop = -longTop;
    		returnIsPos = !returnIsPos;
    	}
    	
    	if (longBottom < 0)
    	{
    		longBottom = -longBottom;
    		returnIsPos = !returnIsPos;
    	}
    	
    	// handle rest of easy checks
    	if (longTop < longBottom)
    	{
    		return 0;
    	}
    	
    	// check for easy edges
    	if (longBottom == 1)
    	{
    		if (returnIsPos)
    		{
    			if (longTop >= Integer.MAX_VALUE)
    			{
    				return Integer.MAX_VALUE;
    			}
    			else
    			{
    				return (int) longTop;
    			}
    		}
    		else
    		{
    			if (-longTop <= Integer.MIN_VALUE)
    			{
    				return Integer.MIN_VALUE;
    			}
    			else
    			{
    				return (int) -longTop;
    			}
    		}
    	}
    	
    	
    	String dividendString = Long.toString(longTop);
    	int i = 0; // i is the next digit to process in the string
    	
    	// build initial dividend
    	long tempDividend = 0;
    	do
    	{
    		try
    		{
    			tempDividend = Long.parseLong(dividendString.substring(0, i + 1));
    		}
    		catch (NumberFormatException e)
    		{
    			System.err.println("whups:\n" + e.getMessage());
    			return 0;
    		}
    		
    		++i;    		
    	}
    	while (tempDividend < longBottom);
    	
    	StringBuilder returnString = new StringBuilder();

    	long tempAnswer = shortDiv(tempDividend, longBottom);
    	returnString.append(Long.toString(tempAnswer));
    	
    	// finish the rest of the dividend
    	while (i < dividendString.length())
    	{
    		tempDividend = tempDividend - shortMult(longBottom, tempAnswer);

    		int loopInt = 0;
    		for (int j = 0; j < 10; ++j)
    		{
    			loopInt += tempDividend;
    		}
    		tempDividend = loopInt;
    		
    		tempDividend += Character.getNumericValue(dividendString.charAt(i));
    		++i;
    		
    		tempAnswer = shortDiv(tempDividend, longBottom);
    		returnString.append(Long.toString(tempAnswer));
    	}
    	
    	int returnInt = 0;
    	
    	try
    	{
    		returnInt = Integer.parseInt(returnString.toString());
    	}
		catch (NumberFormatException e)
		{
			System.err.println("whups2:\n" + e.getMessage());
			return 0;
		}
    	
    	if (!returnIsPos)
    	{
    		returnInt = -returnInt;
    	}
    	
    	return returnInt;
    	
    }
    
    private static long shortDiv(long top, long bottom)
    {
    	long returnint = 0;
    	
    	// bottom will never be zero
    	while (top >= bottom)
    	{
    		top -= bottom;
    		++returnint;
    	}
    	
    	return returnint;
    }
    
    private static long shortMult(long a, long b)
    {
    	long returnint = 0;
    	
    	// needed to get the runtime down
    	long smaller = Math.min(a, b);
    	long larger = Math.max(a, b);
    	
    	for (int i = 0; i < smaller; ++i)
    	{
    		returnint += larger;
    	}
    	
    	return returnint;
    }
}