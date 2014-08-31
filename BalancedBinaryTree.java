package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeUtil.createTree("1,2,2,3,3,#,#,4,4");
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		System.out.println(bbt.isBalanced(root));
	}
	
    public  boolean isBalanced(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	boolean a = isBalanced(root.left);
    	boolean b= isBalanced(root.right);
    	if(a&&b) {
        	int c = getDepth(root.left);
        	int d = getDepth(root.right);
    		return Math.abs(c - d) <= 1;
    	}
    	return false;
    }
    
    private  int getDepth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
    
 }
