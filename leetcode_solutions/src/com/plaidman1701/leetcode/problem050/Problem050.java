package com.plaidman1701.leetcode.problem050;

import java.math.BigDecimal;

public class Problem050 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		System.out.println(soln.myPow(2.0,  -2147483648));
		

	}

}

class Solution {
    public double myPow(double x, int n) {
    	
    	long nLong = n;
    	
    	if (n == 0)
    	{
    		return 1;
    	}
    	if (n == 1)
    	{
    		return x;
    	}
    	if (n == -1)
    	{
    		return 1 / x;
    	}
    	
    	boolean positiveExp = true;
    	if (n < 0)
    	{
    		positiveExp = false;
    		nLong = -nLong;
    	}

    	double carryMultiplier = 1.0;
    	    	
    	while (nLong > 1)
    	{
    		if (nLong % 2 == 1)
    		{
    			--nLong;
    			carryMultiplier *= x;    		}
    		
    		// n is now even
    		nLong /= 2;
    		x *= x;
    	}
    	
    	if (positiveExp)
    	{
    		return x * carryMultiplier;
    	}
    	else
    	{
    		return 1 / (x * carryMultiplier);
    	} 
    	
    }
}