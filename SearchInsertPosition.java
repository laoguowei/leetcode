package com.leetcode;

import java.util.Arrays;

public class SearchInsertPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[10];
		a[0] = 1;
		a[1] = 3;
		a[2] = 5;
		a[3] = 7;
		int[] b = {1,2,3,4,5};
		ListNode head = ListUtil.createList(b);
		reverseBetween(head, 1, 5);
		//System.out.println(maxSubArray(a));
	}
	
    public static int searchInsert(int[] A, int target) {
        int begin = 0; 
        int end = A.length - 1;       
        while(begin <= end) {
        	int middle = (begin + end) / 2;
        	if(A[middle] == target) return middle;
        	else if(A[middle] < target) begin = middle + 1;
        	else end = middle - 1;
        }
        if(end >= 0) return A[end] > target ? begin - 1 : begin;
        return 0;
    }
    
    public static int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < A.length ; i++) {
        	sum += A[i];
        	if(sum > max) max = sum;
        	if(sum < 0) {
        		sum = 0;
        		continue;
        	}
        }
        return max;
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cnt = head;
    	while(l1 != null && l2 != null) {
        	if(l1.val > l2.val) {
        		cnt.next = l2;
        		cnt = cnt.next;
        		l2 = l2.next;
        	} else {
        		cnt.next = l1;
        		cnt = cnt.next;
        		l1 = l1.next;
        	}
        }
    	while(l1 != null) {
    		cnt.next = l1;
    		cnt = cnt.next;
    		l1 = l1.next;
    	}
    	while(l2 != null) {
    		cnt.next = l2;
    		cnt = cnt.next;
    		l2 = l2.next;
    	}
    	return head.next;
    } 
    
    public static void merge(int A[], int m, int B[], int n) {
        int[] tmp = Arrays.copyOf(A, m);
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < m && j < n) {
        	if(tmp[i] < B[j]) A[count++] = tmp[i++];
        	else A[count++] = B[j++];
        }
        while(i < m) A[count++] = tmp[i++];
        while(j < n) A[count++] = B[j++];
    }
    
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode preLink = head;
        ListNode newEnd;
        ListNode newHead;
        ListNode pre;
        ListNode cnt;
        ListNode next;
        while(++i < m) preLink = preLink.next;
    	newEnd = preLink.next;
    	pre = newEnd;	
        if(n - i >= 2) {
        	cnt = pre.next;
        	next = cnt.next;
        	while(i < n) {
        		cnt.next = pre;
        		pre = cnt;
        		cnt = next;
        		if(next != null) {
        			next= next.next;
        		}
        		i++;
        	}
        	newEnd.next = cnt;
        	preLink.next = pre;
        } else if(n - i == 1){
        	cnt = pre.next;
        	preLink.next = cnt;
        	pre.next = cnt.next;
        	cnt.next = pre;
        }
        return head;
    }

}
