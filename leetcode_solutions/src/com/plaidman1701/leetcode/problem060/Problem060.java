package com.plaidman1701.leetcode.problem060;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/permutation-sequence/description/

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/
public class Problem060 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		System.out.println(soln.getPermutation(4, 13));

	}

}

class Solution {
    public String getPermutation(int n, int k) {
    	
    	StringBuilder returnString = new StringBuilder();
    	
    	// build working list and sectionSize
    	List<Integer> numberList = new ArrayList<Integer>();
    	int sectionSize = 1;
    	
    	for (int i = 1; i < n; ++i)
    	{
    		numberList.add(i);
    		sectionSize *= i;
    	}
    	numberList.add(n);

    	while (numberList.size() > 1)
    	{
    		int section = (k - 1) / sectionSize;
    		returnString.append(numberList.get(section));
    		numberList.remove(section);
    		
    		k -= (section * sectionSize);
    		sectionSize /= numberList.size();
    	}
    	returnString.append(numberList.get(0));
    	
    	return returnString.toString();  
    }
}