package com.leetcode;

import java.util.concurrent.Executors;

public class CopyListWithRandomPointer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode nodes = new RandomListNode(0);
		RandomListNode head = nodes;
		for(int i = 0; i < 5; i++) {
			nodes.next = new RandomListNode(i);
			nodes = nodes.next;
		}
		head = head.next;
		head.random = head.next.next;
		head.next.random = head.next.next.next;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head;
		head.next.next.next.next.random = null;
		CopyListWithRandomPointer.copyRandomList(head);

	}
    public static RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null)
    		return null;
    	RandomListNode newHead = new RandomListNode(head.label);
    	RandomListNode oldHead = head;
    	RandomListNode cnt = newHead;
    	oldHead = oldHead.next;
    	int counter = 1;
    	while(oldHead != null) {
    		cnt.next = new RandomListNode(oldHead.label);
    		cnt = cnt.next;
    		oldHead = oldHead.next;
    		counter++;
    	}
    	oldHead = head;
    	cnt = newHead;
    	RandomListNode randomOne;
    	for(int i = 0; i < counter; i++) {
    		randomOne = newHead; 
    		for(int j = 0; j < counter; j++) {
    			if(oldHead.random == null) {
    				oldHead = oldHead.next;
    				break;
    			}
    			int label = oldHead.random.label;
    			if(randomOne.label == label) {
    				cnt.random = randomOne;
    				oldHead = oldHead.next;
    				break;
    			}
    			randomOne = randomOne.next;
    		}
    		cnt = cnt.next;
    	}
    	return newHead;
    }	
	

}

 class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
 };
