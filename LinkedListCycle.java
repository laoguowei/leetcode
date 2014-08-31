package com.leetcode;

import java.util.HashSet;

public class LinkedListCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode nodes = new ListNode(0);
		ListNode head = nodes;
		for(int i = 0; i < 5; i++) {
			nodes.next = new ListNode(0);
			nodes = nodes.next;
		}
	//	ListNode head = ListUtil.createList(new int[]{1,2,3});
		//nodes.next = head.next.next;
		System.out.print(LinkedListCycle.hasCycleNoExtraSpace(head));

	}
	
    public static boolean hasCycle(ListNode head) {
    	HashSet set = new HashSet();
    	while(head != null) {
    		if(!set.contains(head))
    			set.add(head);
    		else
    			return true;
    		head = head.next;
    	}
    	return false;
    }
    //without using extra space
    public static boolean hasCycleNoExtraSpace(ListNode head) {
    	ListNode l1 = head;
    	ListNode l2 = head;
    	while(l1 != null && l2 != null) {
    		if(l2.next != null) {
    			l2 = l2.next.next;
    		} else {
    			l2 = l2.next;
    		}
    		if(l1 == l2) {
    			return true;
    		}
    		l1 = l1.next;
    	}
    	return false;
    }
    
    public ListNode detectCycle(ListNode head) {
    	if(head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null || slow != fast) {
        	fast = fast.next;
        	if(fast != null) fast = fast.next;
        	slow = slow.next;
        }
        if(fast == null) return null;
        slow = head;
        while(slow != fast) {
        	slow = slow.next;
        	fast = fast.next;
        }
        return slow;
    }

}
//
//class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
// }
