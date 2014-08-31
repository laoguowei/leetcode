package com.leetcode;

public class BinaryTreeMaximumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum bt = new BinaryTreeMaximumPathSum();
		TreeNode root = TreeUtil.createTree("-3, -5"); 
		bt.maxPathSum(root);
	}
	
    public int maxPathSum(TreeNode root) {
        TreeNode finalMax = new TreeNode(root.val);
        maxPathSum(root, finalMax);
        return finalMax.val;
    }
	
    public int maxPathSum(TreeNode root, TreeNode finalMax) {
        if(root.left == null && root.right == null) {
        	if(root.val > finalMax.val) finalMax.val = root.val;
        	return root.val;
        }
        
        int leftMax = 0;
        int rightMax = 0;
        
        if(root.left != null) {
        	leftMax = maxPathSum(root.left, finalMax);
        	leftMax = leftMax > 0? leftMax : 0;
        }
        if(root.right != null) {
        	rightMax = maxPathSum(root.right, finalMax);
        	rightMax = rightMax > 0? rightMax : 0;
        }
        
        if(leftMax + rightMax + root.val > finalMax.val) {
        	finalMax.val = leftMax + rightMax + root.val; 
        }
        return leftMax > rightMax ? leftMax + root.val : rightMax + root.val;
    }

}
