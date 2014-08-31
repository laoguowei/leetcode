package com.leetcode.trees;

import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

public class BalancedBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedBinaryTree test = new BalancedBinaryTree();
		TreeNode root = TreeUtil.createTree("1,2,3,4,5");
		boolean re = test.isBalanced(root);
		return;
	}
	/*
	 * ÅĞ¶Ï¶ş²æÊ÷ÊÇ·ñÆ½ºâ¡£
	 * µİ¹éÅĞ¶Ï×óÓÒ×ÓÊ÷ÊÇ·ñÆ½ºâ£¬ÔÙÅĞ¶Ï×óÓÒ×ÓÊ÷¸ß¶È²îÊÇ·ñ²»´óÓÚ1¡£
	 */
	 public boolean isBalanced(TreeNode root) {
		 return isBalanced(root, new TreeNode(0));
	 }
    public boolean isBalanced(TreeNode root, TreeNode height) {
    	if(root == null) {
    		height.val = 0;
    		return true;
    	}
    	if(root.left == null && root.right == null) {
    		height.val = 1;
    		return true;
    	}
    	boolean l = isBalanced(root.left, height);
    	int lH = height.val + 1;
    	boolean r = isBalanced(root.right, height);
    	int rH = height.val + 1;
    	height.val = lH > rH ? lH : rH ;
    	if(Math.abs(lH - rH) > 1) return false;
    	return l & r;
    }

}
