package com.leetcode;

public class ReorderList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderList rl = new ReorderList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = null;
		rl.reorderList(head);
		
	}
	
    public void reorderList(ListNode head) {
    	if(head == null)
    		return;
    	int listLen = 1;
    	int i;
    	int j;
    	ListNode countLen = head;
    	while(countLen.next != null) {
    		listLen++;
    		countLen = countLen.next;
    	}
    	ListNode[] nodeArrays = new ListNode[listLen];
    	ListNode cnt = head;
    	for(i = 0; i < listLen; i++) {
    		nodeArrays[i] = cnt;
    		cnt = cnt.next;
    	}
    	int half = listLen / 2;
    	ListNode right ;
    	ListNode left = head;
    	ListNode nextLeft;
    	for(i = listLen - 1; i > half; i--) {
    		right = nodeArrays[i];
    		nextLeft = left.next;
    		left.next = right;   		
    		right.next = nextLeft;
    		left = nextLeft;
    	}
    	nodeArrays[half].next = null;
    }

}

