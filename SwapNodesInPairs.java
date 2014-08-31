package com.leetcode;

public class SwapNodesInPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {1};
		ListNode head = ListUtil.createList(a);
		head = swapPairs(head);
		ListNode cnt = head;
	}
	
    public static ListNode swapPairs(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode cnt = head;
    	ListNode next = cnt.next;
    	ListNode nnext = next.next;
    	next.next = cnt;
    	cnt.next = swapPairs(nnext);
    	return next;
    }

}
