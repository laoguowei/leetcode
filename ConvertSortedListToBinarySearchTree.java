package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConvertSortedListToBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertSortedListToBinarySearchTree c = new ConvertSortedListToBinarySearchTree();
		List<String> s = new ArrayList();
		int i = 0;
		while(true) {
			s.add(String.valueOf(i++).intern());
		}
	}
    
    public TreeNode sortedListToBST(ListNode head) {
    	TreeNode root = sortedListToBST(head, null);
    	return root;
    }
	
    public TreeNode sortedListToBST(ListNode begin, ListNode end) {
        if(begin == null) {
        	return null;
        }
    	if(begin == end) {
        	return new TreeNode(begin.val);
        }
    	
    	if(begin == null) return null;
    	 
    	if(begin.next == null) {
    		return new TreeNode(begin.val);
    	}
    	if(begin.next.next == null) {
    		TreeNode root = new TreeNode(begin.val);
    		root.right = new TreeNode(begin.next.val);
    		return root;
    	}
    	
        ListNode middle = findMiddle(begin, end);
        TreeNode root = new TreeNode(middle.val);
        root.left = sortedListToBST(begin, middle);
        root.right = sortedListToBST(middle.next, end);
        return root;
    }
    
    public ListNode findMiddle(ListNode head, ListNode end) {
    	ListNode oneStep = head;
    	ListNode twoStep = head;
    	while(twoStep.next != end && twoStep.next.next != end) {
    		twoStep = twoStep.next.next;
    		oneStep = oneStep.next;
    	}
    	return oneStep;
    }
	
    public TreeNode sortedArrayToBST(int[] num) {
    	TreeNode root = sortedArrayToBST(num, 0, num.length - 1);
    	return root;
    }
    
    public TreeNode sortedArrayToBST(int[] num, int begin, int end) {
    	if(begin == end) {
    		return new TreeNode(num[begin]);
    	}
    	if(begin > end) {
    		return null;
    	}
    	int middle = (begin + end) / 2;
    	TreeNode root  = new TreeNode(num[middle]);
    	root.left = sortedArrayToBST(num, begin, middle - 1);
    	root.right = sortedArrayToBST(num, middle + 1, end);
    	return root;
    }

}
