package com.plaidman1701.leetcode.problem002;

/*
 * https://leetcode.com/problems/add-two-numbers/description/
 * 
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/
public class Problem002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int val1;
		int val2;
		int carry = 0;

		ListNode head = null;
		ListNode node = null;

		while (l1 != null || l2 != null || carry != 0) {
			
			val1 = 0;
			val2 = 0;

			if (l1 != null) {
				val1 = l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				val2 = l2.val;
				l2 = l2.next;
			}

			int sum = val1 + val2 + carry;
			carry = sum / 10;

			if (head == null) {
				head = new ListNode(sum % 10);
				node = head;
			} else {
				ListNode tempNode = new ListNode(sum % 10);
				node.next = tempNode;
				node = tempNode;
			}
		}
		
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
