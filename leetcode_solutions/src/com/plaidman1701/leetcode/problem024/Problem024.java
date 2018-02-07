package com.plaidman1701.leetcode.problem024;
/*
https://leetcode.com/problems/swap-nodes-in-pairs/description/

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


*/



public class Problem024 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = null;
		ListNode tailNode = null;

		for (int i = 0; i < 9; ++i) {
			ListNode tempNode = new ListNode(i + 101);

			if (head == null) {
				head = tempNode;
				tailNode = tempNode;
			} else {
				tailNode.next = tempNode;
				tailNode = tempNode;
			}
		}

		printNodes(head);

		Solution soln = new Solution();
		
		head = soln.swapPairs(head);
		
		printNodes(head);

	}

	static void printNodes(ListNode head) {
		ListNode nodeToPrint = head;

		System.out.print("Printing nodes: ");

		while (nodeToPrint != null) {
			System.out.print(nodeToPrint.val + " ");
			nodeToPrint = nodeToPrint.next;
		}

		System.out.println();
	}
}

class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

}

class Solution {
	public ListNode swapPairs(ListNode head) {
		
		if (head == null || head.next == null)
		{
			return head;
		}

		ListNode tempHead = head.next;
		
		ListNode twotemp = head.next;
		head.next = head.next.next;
		twotemp.next = head;
		
		while ((head.next != null) && (head.next.next != null)) // only keep going if next two nodes present
		{
			twotemp = head.next;
			head.next = twotemp.next;
			twotemp.next = twotemp.next.next;
			head.next.next = twotemp;
			head = twotemp;
		}

		return tempHead;
	}
}