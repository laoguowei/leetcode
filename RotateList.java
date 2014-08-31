package com.leetcode;

public class RotateList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateList r = new RotateList();
		ListNode head = ListUtil.createList(new int[]{1,2,3});
		r.reorderList(head);
	}
	
    public void reorderList(ListNode head) {
    	if(head == null || head.next == null) return;
        ListNode twoStep = head;
        ListNode oneStep = head;
        while(twoStep != null) {
        	twoStep = twoStep.next;
        	if(twoStep != null) twoStep = twoStep.next;
        	else break;
        	oneStep = oneStep.next;
        }
        ListNode r = reverseList(oneStep.next);
        ListNode l = head;
        oneStep.next = null;
        boolean swap = true;
        while(l != null && r != null) {
        	ListNode tmp;
        	if(swap) {
        		tmp = l.next;
        		l.next = r;
        		l = tmp;
        		swap = false;
        	} else {
        		tmp = r.next;
        		r.next = l;
        		r = tmp;
        		swap = true;
        	}
        }
    }
    
    public ListNode reverseList(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode pre = head;
    	ListNode cnt = head.next;
    	ListNode next = cnt.next;
    	pre.next = null;
    	while(cnt != null) {
    		cnt.next = pre;
    		pre = cnt;
    		cnt = next;
    		if(next != null) next = next.next;
    	}
    	return pre;
    }
	
    
    

}
