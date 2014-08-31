package com.leetcode.trees;

import java.util.Stack;

import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

public class FlattenBinaryTreeToLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
		TreeNode root = TreeUtil.createTree("1,2,5,3,4,6,7");
		test.flatten(root);
	}
	
	/*
	 * 将二叉树转换为单支的结构
	 * 思路就是写一个非递归的前序遍历。
	 */
    public void flatten(TreeNode tmproot) {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode root =tmproot;
    	while(root != null || !stack.isEmpty()) {
    		if(root.right != null) {
    			stack.push(root.right);
    		}
    		if(root.left != null) {
    			TreeNode tmp = root.left;
    			root.right = tmp;
    			root.left = null;
    			root = tmp;
    		} else {
    			if(!stack.isEmpty()){
    				TreeNode t = stack.pop();
    				root.right = t;
    				root = t;
    			} else {
    				root = null;
    			}
    		}
    	}
    }

}
