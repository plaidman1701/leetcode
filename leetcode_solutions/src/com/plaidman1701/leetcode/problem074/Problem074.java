package com.plaidman1701.leetcode.problem074;
/*


*/
public class Problem074 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		int[][] matrix = new int[][] {
			{1, 3, 5, 7},
			{10, 11, 16, 20},
			{23, 30, 34, 50}
		};
		
		System.out.println(soln.searchMatrix(matrix, 10));

	}

}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	
    	// quick checks
    	if ((matrix.length == 0) || (matrix[0].length == 0) || (matrix[0][0] > target) || (matrix[matrix.length - 1][matrix[0].length - 1] < target))
    	{
    		return false;
    	}
    	
    	int targetArray = findArray(matrix, target, 0, matrix.length - 1);
    	if (targetArray == -1) // value is between arrays
    	{
    		return false;
    	}
    	
    	return findValue(matrix[targetArray], target, 0, matrix[targetArray].length - 1);
        
    }
    
    private int findArray(int[][] matrix, int target, int start, int end)
    {
    	// check outside range
    	if ((matrix[start][0] > target) || (matrix[end][matrix[end].length - 1] < target))
    	{
    		return -1;
    	}
    	
    	int midpoint = ((end - start) / 2) + start;
    	
    	if ((matrix[midpoint][0] <= target) && (matrix[midpoint][matrix[0].length - 1] >= target))
    	{
    		return midpoint;
    	}
    	
    	if (matrix[midpoint][0] > target)
    	{
    		return findArray(matrix, target, start, midpoint - 1);
    	}
    	else
    	{
    		return findArray(matrix, target, midpoint + 1, end);
    	}
    }
    
    private boolean findValue(int[] arr, int target, int start, int end)
    {
    	// check outside range
    	if ((arr[start] > target) || arr[end] < target)
    	{
    		return false;
    	}
    	
    	int midpoint = ((end - start) / 2) + start;
    	
    	if (arr[midpoint] == target)
    	{
    		return true;
    	}
    	
    	if (arr[midpoint] > target)
    	{
    		return findValue(arr, target, start, midpoint - 1);
    	}
    	else
    	{
    		return findValue(arr, target, midpoint + 1, end);
    	}
    }
}