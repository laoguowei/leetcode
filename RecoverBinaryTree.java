package com.leetcode;

import java.util.Stack;

public class RecoverBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		postfix("a+b*(c-d)-e/f");
	}
	
	public static void recoverTree(TreeNode root) {

	}
	

	    
	    public static boolean isValidBST(TreeNode root, int[] couple) { //0 : min  1: max
	        if(root == null) return false;
	        if(root.right == null && root.left == null) {
	        	couple[0] = root.val;
	        	couple[1] = root.val;
	        	return true;
	        }
	        boolean left = true;
	        boolean right = true;
	        int[] leftCouple = new int[2];
	        int []rightCouple = new int[2];
	        
	        for(int i = 0; i < 2; i++) {
	        	leftCouple[i] = root.val;
	        	rightCouple[i] = root.val;
	        }

	        if(root.left != null) {
	        	left = isValidBST(root.left, leftCouple);
	        	if(root.val <=  leftCouple[1]) {
	        		return false;
	        	}
	        }
	        
	        if(root.right != null) {
	    		right = isValidBST(root.right, rightCouple);
	        	if(rightCouple[0] <= root.val) {
	        		return false;
	        	}
	        }      
	        couple[0] = leftCouple[0];
	        couple[1] = rightCouple[1];
	        return left & right;    
	    }
	    
	    public static ListNode reverseList(ListNode head) {
	    	if(head == null || head.next == null) return head;
	    	ListNode cnt = head.next;
	    	ListNode pre = head;
	    	ListNode next = cnt.next;
	    	head.next = null;
	    	while(cnt != null) {
	    		cnt.next = pre;
	    		pre = cnt;
	    		cnt = next;
	    		if(next != null)
	    		next = next.next;
	    	}
	    	return pre;
	    }
	    
	    public static String postfix(String s) {
	    	StringBuilder sb = new StringBuilder();
	    	Stack<Character> stack = new Stack();
	    	int i = 0;
	    	while(i < s.length() || !stack.isEmpty()) {
	    		if(i < s.length()) {
		    		if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') sb.append(s.charAt(i++));
		    		else {
		    			char tmp = s.charAt(i);
		    			if(stack.isEmpty()) {
		    				stack.push(tmp);
		    				i++;
		    				continue;
		    			}
		    			char peek = stack.peek();
		    			if(isp(peek)  < icp(tmp)) {
		    				stack.push(tmp);
		    				i++;
		    			} else if (isp(peek)  > icp(tmp)) {
		    				sb.append(stack.pop());
		    			} else {
		    				if(stack.pop() == '(') i++;
		    			}
		    		}
		    	} else {
		    		sb.append(stack.pop());
		    	}
	    	}
	    	return sb.toString();
	    }
	    
	    private static int isp (char c) {
	    	if(c =='(') return 1;
	    	else if(c =='*' || c =='%' || c =='/') return 5;
	    	else if(c =='+' || c == '-') return 3;
	    	else if(c == ')') return 6;
	    	
	    	return 0;
	    }
	    
	    private static int icp(char c) {
	    	if(c == '(') return 6;
	    	else if(c == ')') return 1;
	    	else return isp(c) - 1;
	    }
}
