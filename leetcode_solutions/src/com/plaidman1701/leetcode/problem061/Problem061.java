package com.plaidman1701.leetcode.problem061;

/*
https://leetcode.com/problems/rotate-list/description/

Given a list, rotate the list to the right by k places, where k is non-negative.


Example:

Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.
*/
public class Problem061 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode head = new ListNode(1);
		ListNode tail = head;
		head.next = tail;
		
		for (int i = 2; i <= 5; ++i)
		{
			ListNode temp = new ListNode(i);
			tail.next = temp;
			tail = temp;
		}
		
		printList(head);
		
		Solution soln = new Solution();
		printList(soln.rotateRight(head, 6));

	}
	
	private static void printList(ListNode ln)
	{
		ListNode pointer = ln;
		while (pointer != null)
		{
			System.out.print(pointer.val + " -> ");
			pointer = pointer.next;
		}
		System.out.println("null");
	}

}

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		
		if ((k == 0) || head == null || head.next == null)
		{
			return head;
		}
		
		ListNode scout = head;
		ListNode grabber = head;
		
		int listSize = 1;
		
		while (k > 0)
		{
			--k;
			if (scout.next == null) // gets to the end
			{
				scout = head;
				k %= listSize;
			}
			else
			{
				scout = scout.next;
				
				++listSize;
			}
		}
		
		// check edges
		if (scout == null)
		{
			return head;
		}
		
		while (scout.next != null)
		{
			scout = scout.next;
			grabber = grabber.next;
		}
		
		scout.next = head;
		head = grabber.next;
		grabber.next = null;
		
		return head;
	}
}