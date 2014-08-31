package com.leetcode.trees;

import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

public class BinaryTreeMaximumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();	
		TreeNode root = TreeUtil.createTree("9,6,-3,#,#,-6,2,#,#,2,#,-6,-6,-6");
		test.maxPathSum(root);
			
	}
	
	
	/*
	 * 求二叉树中一条路径上的值的最大和。路径的起点和终点可以为任意位置
	 * 还是得用递归做。思路是：对于一棵树，比较根(root)、左子树最大路径值(lvalue)、右子树最大路径值(rvalue)。
	 * 具体比较 root + rvalue+ lvalue ,  root , rvalue , lvalue 取其中的最大者和已有的max比较。如果比max大就更新max
	 * 返回的时候，返回 root , root + lvalue, root + rvalue 中的最大值。 之所以不返回 root + rvalue+ lvalue 是因为路径的计算只能取一条。不能回头
	 * 
	 */
	
	 public int maxPathSum(TreeNode root) {
		 int[] max = new int[] {Integer.MIN_VALUE};
		 maxPathSum(root, max);
		 return max[0];
	 }

    public int maxPathSum(TreeNode root, int[] max) {
    	if(root.left == null && root.right == null) {
    		if(root.val > max[0]) {
    			max[0] = root.val;
    		}
    		return root.val;
    	}
    	int lMax = 0;
    	int rMax = 0;
    	int tmp = 0;
    	if(root.left != null) {
    		lMax = maxPathSum(root.left, max);
    	}
    	
    	if(root.right != null) {
    		rMax = maxPathSum(root.right, max);
    	}
    	
    	tmp = rMax > lMax ? rMax  + root.val : lMax + root.val;
    	if(root.val > max[0]) max[0] = root.val; 
    	if(rMax + lMax + root.val > max[0]) max[0] = rMax + lMax + root.val;
    	if(tmp > max[0]) max[0] = tmp;
    	return tmp > root.val ? tmp : root.val;
    }
}
