package com.leetcode;

public class MaximumDepthOfBinaryTree {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeUtil.createTree("#");//"1,1,1,1,1,#,#,1,1,#,#,#,#,1,1,1");
		MaximumDepthOfBinaryTree mdbt = new MaximumDepthOfBinaryTree();
		System.out.print(mdbt.maxDepth(root));
	}
	
    public int maxDepth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	if(root.left == null && root.right == null) {
    		return 1;
    	}
    	int left = 1;
    	int right = 1;
    	if(root.left != null) {
    		left = maxDepth(root.left) + 1;
    	}
    	if(root.right != null) {
    		right = maxDepth(root.right) + 1;
    	}
    	return Math.max(left, right);
    }

}
