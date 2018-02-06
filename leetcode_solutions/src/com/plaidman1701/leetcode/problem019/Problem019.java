package com.plaidman1701.leetcode.problem019;

/*

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

*/

import java.util.ArrayList;
import java.util.List;

public class Problem019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode head = null;
		ListNode tailNode= null;
		
		for (int i = 0; i < 10; ++i)
		{
			ListNode tempNode = new ListNode(i + 101);
			
			if (head == null)
			{
				head = tempNode;
				tailNode = tempNode;
			}
			else
			{
				tailNode.next = tempNode;
				tailNode = tempNode;
			}			
		}
		printNodes(head);

		Solution soln = new Solution();
		head = soln.removeNthFromEnd(head, 10);
		
		printNodes(head);
	}
	
	static void printNodes(ListNode head)
	{
		ListNode nodeToPrint = head;
		
		System.out.print("Printing nodes: ");
		
		while (nodeToPrint != null)
		{
			System.out.print(nodeToPrint.val + " ");
			nodeToPrint = nodeToPrint.next;
		}
		
		System.out.println();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	
    	List<ListNode> ListNodeAL = new ArrayList<ListNode>();
    	
    	ListNode nodeToAdd = head;
    	
    	while (nodeToAdd != null)
    	{
    		ListNodeAL.add(nodeToAdd);
    		nodeToAdd = nodeToAdd.next;
    	}
    	
    	if (n > ListNodeAL.size()) // nonsensical
    	{
    		return null;
    	}
    	else if (n == ListNodeAL.size()) // first node
    	{
    		head = head.next;
    		return head;
    	}
    	
    	// otherwise, find part to cut
    	ListNode nodeToChange = ListNodeAL.get(ListNodeAL.size() - n - 1);
    	
    	if (nodeToChange.next != null && nodeToChange.next.next != null)
    	{
    		nodeToChange.next = nodeToChange.next.next;
    	}
    	else // must be last node
    	{
    		nodeToChange.next = null;
    	}
    	
    	return head;
    }
}




