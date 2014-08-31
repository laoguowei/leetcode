package com.leetcode;

public class SortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortList sl =new SortList();
		ListNode x = new ListNode(3);
		x.next = new ListNode(5);
		x.next.next = new ListNode(4);
		x.next.next.next = new ListNode(2);
		x.next.next.next.next = new ListNode(1);
		sl.partition(x, null);
		String s= "fsdf";
		

	}
    public ListNode sortList(ListNode head, ListNode end) {
    	if(head.next == end) {
    		return head;
    	}
    	ListNode leftEnd = partition(head, end);
		ListNode mid = leftEnd.next;
		head = sortList(head, leftEnd);
		mid.next = sortList(mid.next, end);
		return head;
    }
    
    public ListNode partition(ListNode head, ListNode end) {
    	ListNode tmp = head;
    	ListNode cnt = head;
		ListNode biger = null;
		ListNode leftEnd = head;
		while(cnt != null) {
			if(cnt.val < tmp.val) {
				if(biger != null) {
					int tmpp = biger.val;
					biger.val = cnt.val;
					cnt.val = tmpp;
					leftEnd = biger;
					biger = biger.next;
				} 
				leftEnd = cnt;
			} else {
				if(biger == null) {
					biger = cnt;
				}
			}
			cnt = cnt.next;    			
		}	
		return leftEnd;
    		
    }

    class NodeWrapper {
    	ListNode left;
    	ListNode right;	
    	int mid;
    }
}
