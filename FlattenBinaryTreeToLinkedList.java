package com.leetcode;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeUtil.createTree("1,1");
		boolean b = isValidBST(root);
		System.out.print(b);
	}
	
    public static void flatten(TreeNode root) {
    	if(root ==null) return;
    	Stack<TreeNode> stack = new Stack();
    	while(root != null) {
    		if(root.right != null) stack.push(root.right);
    		if(root.left != null) {
    			root.right = root.left;
    			root.left = null;
    			root = root.right;
    		} else {
    			if(!stack.isEmpty()) {
    				root.right = stack.pop();
    				root = root.right;
    			} else {
    				root = null;
    			}
    		}
    	}
    }
    
    
    public static int minDepth(TreeNode root) {
        if(root.left == null && root.right == null) {
        	return 1;
        }
        int r = Integer.MAX_VALUE ;
        int l = Integer.MAX_VALUE ;
        if(root.left != null) {
        	l = 1 + minDepth(root.left);
        }
        if(root.right != null) {
        	r = 1 + minDepth(root.right);
        }
        return l < r ? l : r;
    }
    
    public static boolean isValidBST(TreeNode root) { 
    	int []couple = new int[2];
    	return isValidBST(root, couple);
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
}
