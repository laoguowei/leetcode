package com.leetcode.trees;

import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

public class MinimumDepthOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeUtil.createTree("1,2,#,3,4,5");
		MinimumDepthOfBinaryTree test = new MinimumDepthOfBinaryTree();
		int d = test.minDepth(root);
		return;
	}
	
	/**
	 * 求二叉树最小深度
	 * 递归计算，如果节点为叶子节点，则返回1，如果不是，则考察其左右非空子树。根的深度为1
	 * 
	 * 
	 */
	
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
    	if(root.left == null && root.right == null) return 1;
    	int lMin = 0;
    	int rMin = 0;
    	if(root.left != null && root.right != null) {
    	    lMin = minDepth(root.left);
    	    rMin = minDepth(root.right);
    	    return lMin > rMin ? rMin + 1 : lMin + 1;
    	} else if(root.left != null && root.right == null) {
    	    return minDepth(root.left) + 1;
    	} else {
    	    return minDepth(root.right) + 1;
    	}
    }

}
