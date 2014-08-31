package com.leetcode;

import java.io.ObjectInputStream.GetField;
import java.util.List;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	private static final int  TEST = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode[] l1 = new ListNode[3];
		ListNode[] l2 = new ListNode[3];
		for(int i = 0; i < 3; i++) {
			l1[i] = new ListNode(0);
			l2[i] = new ListNode(0);
		}
//		l1[0].val = 9;
//		l1[1].val = 9;
//		l1[2].val = 9;
//		
//		l2[0].val = 9;
//		l2[1].val = 9;
//		l2[2].val = 9;
//		l1[0].next = l1[1];
//		l1[1].next = l1[2];
//		l2[0].next = l2[1];
//		l2[1].next = l2[2];
//		l2[2].next = new ListNode(9);
		l1[0].val = 0;
		l2[0].val = 0;
		AddTwoNumbers a = new AddTwoNumbers();
		a.addTwoNumbers(l1[0], l2[0]);
		Class c = AddTwoNumbers.class;
		String packge = c.getPackage().getName();
		System.out.println(packge);
		
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode lowBit = new ListNode(0);
    	ListNode cnt = lowBit;
    	int cntValue = 0;
    	int adding = 0;
    	while(l1 != null && l2 != null) {
    		cnt.next = new ListNode(0);
    		cnt = cnt.next;
    		cntValue = l1.val + l2.val + adding; 
    		if(cntValue <= 9) {
    			cnt.val = cntValue;
    			adding = 0;
    		} else {
    			cnt.val = cntValue % 10;
    			adding = 1;
    		}
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	if(l1 != null || l2 != null) {
    		while(l1 != null) {
    			cnt.next = new ListNode(0);
    			cnt = cnt.next;
    			cntValue = l1.val + adding;
    			if(cntValue  <= 9) {
    				cnt.val = cntValue;
    				adding = 0;
    			} else {
    				cnt.val = cntValue % 10;
        			adding = 1;
    			}
        		l1 = l1.next;
        	}
      	
        	while(l2 != null) {
        		cnt.next = new ListNode(0);
    			cnt = cnt.next;
    			cntValue = l2.val + adding;
    			if(cntValue  <= 9) {
    				cnt.val = cntValue;
    				adding = 0;
    			} else {
    				cnt.val = cntValue % 10;
        			adding = 1;
    			}
        		l2 = l2.next;
        	}   	
    	} 
    	
    	if(adding == 1) {
			cnt.next = new ListNode(1);
    	}
    	return lowBit.next;
    	
    }
}


