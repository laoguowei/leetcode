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
	 * ���������С���
	 * �ݹ���㣬����ڵ�ΪҶ�ӽڵ㣬�򷵻�1��������ǣ��򿼲������ҷǿ��������������Ϊ1
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
