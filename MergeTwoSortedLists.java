package com.leetcode;

public class MergeTwoSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		MergeTwoSortedLists mo = new MergeTwoSortedLists();
		mo.mergeTwoLists(l1, null);
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode cnt = head;
		while(l1 != null && l2 != null) {
			if(l1.val > l2.val) {
				cnt.next = l2;
				l2 = l2.next;
			} else {
				cnt.next = l1;
				l1 = l1.next;
			}
			cnt = cnt.next;
		}
		while(l1 != null) {
			cnt.next = l1;
			l1 = l1.next;
			cnt = cnt.next;
		}
		while(l2 != null) {
			cnt.next = l2;
			l2 = l2.next;
			cnt = cnt.next;
		}
		return head.next;
    }
	

}
