package com.plaidman1701.leetcode.problem056;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
https://leetcode.com/problems/merge-intervals/description/

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/
public class Problem056 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Interval> intervals = new ArrayList<Interval>();
		
		
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(2, 4));
		intervals.add(new Interval(15, 18));
		
		/*
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(2, 3));
		*/
		Solution soln = new Solution();
		
		printList(intervals);
		System.out.println("---");
		printList(soln.merge(intervals));


	}
	
	private static void printList(List<Interval> listToPrint)
	{
		for (Interval i : listToPrint)
		{
			System.out.println(i.start + " " + i.end);
		}
	}

}

// Definition for an interval. Can't use a comparitor
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}


class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		
		if (intervals.size() < 2)
		{
			return intervals;
		}
		
		Map<Integer, Integer> intervalMap = new TreeMap<Integer, Integer>(); // represents the first value of the node, and the maximum matching second value
		
		for (Interval interval : intervals) // combine all the intervals that start with the same value
		{
			if ((intervalMap.get(interval.start) == null) || (intervalMap.get(interval.start) < interval.end))
			{
				intervalMap.put(interval.start, interval.end);
			}
		}
		
		List<Interval> returnList = new ArrayList<Interval>();
		
		for (int i : intervalMap.keySet())
		{
			returnList.add(new Interval(i, intervalMap.get(i)));
		}
		
		int i = 0;
		while (i < returnList.size() - 1) // check to 2nd-last value
		{
			if (returnList.get(i).end >= returnList.get(i + 1).start)
			{
				if (returnList.get(i + 1).end > returnList.get(i).end) // if worthwhile, replace end
				{
					returnList.get(i).end = returnList.get(i + 1).end;
				}
				// in either case, delete superfluous node
				returnList.remove(i + 1);
			}
			else // can't merge with next node, move up
			{
				++i;
			}
		}
		
		return returnList;

	}
}