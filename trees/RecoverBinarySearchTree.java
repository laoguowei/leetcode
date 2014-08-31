package com.leetcode.trees;

import java.util.ArrayList;

import com.leetcode.TreeNode;
import com.leetcode.TreeUtil;

public class RecoverBinarySearchTree {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecoverBinarySearchTree test = new RecoverBinarySearchTree();
		TreeNode root = TreeUtil.createTree("2,#,3,1");
		test.recoverTree(root);
		return;

	}
	
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> p = new ArrayList<TreeNode>();
        recoverTree(root, p);
        TreeNode n1 = p.get(0);
        TreeNode n2 = p.get(1);
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
	
    public int recoverTree(TreeNode root, ArrayList<TreeNode> p) {
    	if(root.left ==null && root.right == null) return root.val;
    	if(root.left != null) {
    		int curV = root.val;
    		int preV = recoverTree(root.left, p);
    		if(preV > curV) {
    			p.add(root.left);
    		}
    	} 
    	if(root.right != null) {
    		int curV = root.val;
    		int nextV = recoverTree(root.right, p);
    		if(curV > nextV) {
    			p.add(root);
    		}
    	}
    	return root.val;
    }
    
    

}
