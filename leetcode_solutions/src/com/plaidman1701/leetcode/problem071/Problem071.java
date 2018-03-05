package com.plaidman1701.leetcode.problem071;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/simplify-path/description/

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
public class Problem071 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution soln = new Solution();
		
		System.out.println(soln.simplifyPath("/home/"));
		System.out.println(soln.simplifyPath("/a/./b/../..////c/"));
		System.out.println(soln.simplifyPath("/home//foo/"));


	}

}

class Solution {
    public String simplifyPath(String path) {
    	
    	
    	if ((path == null) || (path.isEmpty()))
    	{
    		return new String();
    	}
    	
    	String[] pathArray = path.split("/");
    	
    	List<String> pathList = new ArrayList<String>();
    	
    	for (String s : pathArray)
    	{
    		if ((s == null) || s.isEmpty() || s.equals("."))
    		{
    			continue;
    		}
    		
    		if (s.equals(".."))
    		{
    			if (pathList.size() > 0)
    			{
    				pathList.remove(pathList.size() - 1);
    			}
    		}
    		else
    		{
    			pathList.add(s);
    		}
    	}
    	
    	StringBuilder returnString = new StringBuilder();
    	
    	for (String s : pathList)
    	{
    		returnString.append("/").append(s);
    	}
    	
    	return ((returnString.length() == 0) ? "/" : returnString.toString());
    	
    }
}