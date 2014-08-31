package com.leetcode;

import java.util.ArrayList;

public class SumRootToLeafNumbers {

	private ArrayList<String> values = new ArrayList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumRootToLeafNumbers sn = new SumRootToLeafNumbers();
		TreeNode root = TreeUtil.createTree("1,2,3,4,#,5,#,#,#,8,9");
		System.out.println(sn.sumNumbers(root));
	}
	
    public int sumNumbers(TreeNode root) {
        getPathNum(root, new StringBuilder());
        int sum = 0;
        for(int i = 0; i < values.size(); i++) {
        	sum += Integer.parseInt(values.get(i));
        }
        return sum;
    }
    
    public void getPathNum(TreeNode root, StringBuilder num) {
    	if(root == null) {
    		return;
    	}
    	if(root.left == null && root.right == null) {
    		num.append(root.val);
    		String sb = num.toString();
    		values.add(sb);
    		return;
    	}
    	num.append(root.val);
    	if(root.left != null) {		
    		getPathNum(root.left, num);
    		num.deleteCharAt(num.length() - 1);
    	}
    	
    	if(root.right != null) {
    		getPathNum(root.right, num);
    		num.deleteCharAt(num.length() - 1);
    	}
    	
    }

}
