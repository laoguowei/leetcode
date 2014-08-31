package com.leetcode;

public class ListUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode createList(int[] a) {
		ListNode head = new ListNode(-1);
		ListNode cnt = head;
		for(int i =0; i < a.length; i++) {
			cnt.next = new ListNode(a[i]);
			cnt = cnt.next;
		}
		return head.next;
	}

}
