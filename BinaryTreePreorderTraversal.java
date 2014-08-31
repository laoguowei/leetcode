package com.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeUtil.createTree("1,2,#,3,#,4,5");
		inorderTraversal(root);
	}
	
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> results = new ArrayList<Integer>();
    	if(root == null) return results;
    	Stack<TreeNode> stack = new Stack();
    	while(root != null) {
    		results.add(root.val);
    		if(root.right != null) stack.push(root.right);
    		if(root.left != null) {
    			root = root.left;
    		}
    		else {
    			if(!stack.isEmpty()) {
    				root = stack.pop();
    			} else {
    				root = null;
    			}
    		}
    	} 
    	return results;
    }
    
    
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> results = new ArrayList<Integer>();
    	if(root == null) return results;
    	Stack<TreeNode> stack = new Stack();
    	boolean isPop = false;
    	while(root != null) {
    		if(!isPop) {
    			if(root.left != null) {
    				stack.push(root);
    				root = root.left;
    			} else {
    				results.add(root.val);
    				if(root.right != null) {
    					root = root.right;
    				} else {
    	    			if(!stack.isEmpty()) {
    	    				root = stack.pop();
    	    			} else {
    	    				root = null;
    	    			}
    	    			isPop = true;
    				}
    			}
    		} else {
    			results.add(root.val);
    			if(root.right != null) {
    				root = root.right;
        			isPop = false;
    			} else {
	    			if(!stack.isEmpty()) {
	    				root = stack.pop();
	        			isPop = true;
	    			} else {
	    				root = null;
	    			}
    			}
    		}
    	} 
    	return results;
    }

}
