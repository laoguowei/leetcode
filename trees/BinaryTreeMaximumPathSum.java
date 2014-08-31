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
	 * ���ǵ��õݹ�����˼·�ǣ�����һ�������Ƚϸ�(root)�����������·��ֵ(lvalue)�����������·��ֵ(rvalue)��
	 * ����Ƚ� root + rvalue+ lvalue ,  root , rvalue , lvalue ȡ���е�����ߺ����е�max�Ƚϡ������max��͸���max
	 * ���ص�ʱ�򣬷��� root , root + lvalue, root + rvalue �е����ֵ�� ֮���Բ����� root + rvalue+ lvalue ����Ϊ·���ļ���ֻ��ȡһ�������ܻ�ͷ
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
