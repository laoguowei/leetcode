package com.leetcode;

public class ReverseNodesInkGroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseNodesInkGroup r = new ReverseNodesInkGroup();
		int[] a = {1,2,3,4,5,6,7,8};
 		ListNode head = ListUtil.createList(a);
 		r.reverseKGroup(head, 3);
	}
	
	   public ListNode reverseKGroup(ListNode head, int k) {
		   int i = 0;
		   ListNode next = head;
		   ListNode cnt = head;
		   while(next != null && i < k) {
			   next = next.next;
			   i++;
		   }
		   if(i < k) {
			   return head;
		   } else {
			  head = reverseKGroup2(cnt, k);
		   }
		   i = 0;
		   while(next != null) {
			   while(next != null && i < k) {
				   next = next.next;
				   i++;
			   }
			   if(i < k) {
				   return head;
			   } else {
				   ListNode tmp = cnt.next;
				  cnt.next = reverseKGroup2(tmp, k);
				  cnt = tmp;	
			   }
			   i = 0;
		   }
		   return head;
	   }
	
    public ListNode reverseKGroup2(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cnt = head.next;
        ListNode next = cnt.next;

        int i = 1;
        while(i < k && cnt != null) {
        	cnt.next = pre;
        	pre = cnt;
        	cnt = next;
        	if(next != null)
        		next = next.next;
        	i++;
        }
        head.next = cnt;
        return pre;
    }
	

}
