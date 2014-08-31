package com.leetcode;

public class SameTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = TreeUtil.createTree("#");
		TreeNode root2 = TreeUtil.createTree("1");
		SameTree st = new SameTree();
		System.out.println(st.isSameTree(root1, root2));
	}
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null) {
        	if(p.val != q.val) {
        		return false;
        	}
        	boolean leftSide = isSameTree(p.left, q.left);
        	boolean rightSide = isSameTree(p.right, q.right);
        	return leftSide & rightSide;        	
        } else if(p == null && q == null) {
        	return true;
        } else {
        	return false;
        }
    }
}
