package com.leetcode;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,1};
		ListNode head = ListUtil.createList(a);
		deleteDuplicates2(head);
	}
	
    
    public static ListNode deleteDuplicates(ListNode head) {
    	ListNode cnt = head;
    	if(head == null || head.next == null) return head;
    	while(head != null) {
    		if(head.next != null && head.val == head.next.val) {
    			head.next = head.next.next;
    			continue;
    		}
    		head = head.next;
    	}
    	return cnt;
    }
    
    public static ListNode deleteDuplicates2(ListNode head) {
    	ListNode cnt = head;
    	int count = 0;
    	if(head == null || head.next == null) return head;	
    	while(head != null && head.next != null && head.val == head.next.val) {
	    	while(head != null && head.next != null && head.val == head.next.val) {
	    		head = head.next;
	    	}
	    	head = head.next;
    	}
    	cnt = head;
    	ListNode pre = cnt;
    	while(head != null) {
    		count = 0;
    		while(head.next != null && head.val == head.next.val) {
    			head = head.next;
    			count++;
    		}
    		if(count > 0) {
    			pre.next = head.next;
    		} else {
    			pre = head;
    		}
    		head = head.next;
    	}
    	return cnt;
    }
	
    public static int removeDuplicates(int[] A) {
    	int fillPoint = 0;
    	for(int i = 0; i < A.length; i++) {
    		if(i + 1 < A.length && A[i] == A[i + 1]) continue;
    		else {
    			A[fillPoint] = A[i];
    			fillPoint++;
    		}
    	}
    	return fillPoint;
    }

    public static int removeDuplicates2(int[] A) {
    	int fillPoint = 0;
    	int countTwo = 1;
    	for(int i = 0; i < A.length; i++) {
    		if(i + 1 < A.length && A[i] == A[i + 1] && countTwo >= 2) {
    			countTwo++;
    		} else {
    			A[fillPoint] = A[i];
    			fillPoint++;
    			if(countTwo >= 2) countTwo = 1;
    			else if(i + 1 < A.length && A[i] == A[i + 1]) countTwo++;
    		}
    		
    	}
    	return fillPoint;
    }
    
    public int search(int[] A, int target) {
        int min = searchMin(A);
        if(target <= A[A.length - 1]) {
        	return bSearch(A, target, min, A.length - 1);
        } else {
        	return bSearch(A, target, 0, min - 1);
        }
    }
    
    public int bSearch(int[] A, int target, int begin, int end) {
    	int l = begin;
    	int r = end;
    	int middle;
    	while(l < r) {
    		middle = (l + r) / 2;
    		if(A[middle] > target) {
    			r = middle - 1;
    		} else if(A[middle] < target){
    			l = middle + 1;
    		} else {
    			return middle;
    		}
    	}
    	return A[l] == target ? l : -1;
    }
    
    public int searchMin(int[] A) {
        int begin = 0;
        int end = A.length - 1;
        int middle;
        if(A[begin] < A[end]) return begin;
        middle = (begin + end) / 2;
        while(begin < end) {
        		middle = (begin + end) / 2;
        		if(A[middle] < A[end]) {
        			if(middle > 0 && A[middle - 1] < A[middle]) {
        				end = middle - 1;
        			}
        			else {
        				return middle;
        			}
        		} else {
        			if(middle < A.length && A[middle] < A[middle + 1]) {
        				begin = middle + 1;
        			} else {
        				return middle + 1;
        			}
        		}
        }
        return begin;
    }
    
    public static int[] plusOne(int[] digits) {
    	int carry = 1;
    	boolean needNew = false;
    	int[] newOne = new int[1 + digits.length];
    	newOne[0] = 1;
    	for(int i = digits.length - 1; i >=0; i--) {
    		int tmp = digits[i] + carry;
    		if(tmp >= 10) carry = 1;
    		else carry = 0;
    		newOne[i + 1] = tmp % 10;
    		if(i == 0 && carry == 1) {
    			needNew = true; 
    		}
    	}
    	if(needNew) {
    		return newOne;
    	} else {
    		return Arrays.copyOfRange(newOne, 1, newOne.length);
    	}
    }


}
