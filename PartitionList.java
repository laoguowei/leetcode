package com.leetcode;

public class PartitionList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,1,4,5,6};
 		ListNode head = ListUtil.createList(a);
 		PartitionList pl = new PartitionList();
 		pl.partition(head, 2);
	}
	
    public ListNode partition(ListNode head, int x) {
    	if(head == null || head.val == Integer.MAX_VALUE) 
    		return head;
    	ListNode bigerHeadPre = null;
    	ListNode cnt = head;
    	ListNode pre = cnt;
    	while(cnt != null) {
    		if(cnt.val < x) {
    			if(bigerHeadPre == null) {
    				pre = cnt;
    				cnt = cnt.next;
    			} else if(bigerHeadPre.val != Integer.MAX_VALUE){
    				pre.next = cnt.next;
    				cnt.next = bigerHeadPre.next;
    				bigerHeadPre.next = cnt;
    				bigerHeadPre = cnt;
    				cnt = pre.next;
    			} else {
    				pre.next = cnt.next;
    				cnt.next = head;
    				bigerHeadPre = cnt;
    				head = cnt;
    				cnt = pre.next;
    			}
    		} else {
    			if(bigerHeadPre == null) {
    				if(cnt != head) {
    					bigerHeadPre = pre;
    				} else {
    					bigerHeadPre = new ListNode(Integer.MAX_VALUE);
    				}
    			}
    			pre = cnt;
    			cnt = cnt.next;
    		}	
    	}
    	return head;
    }

}
