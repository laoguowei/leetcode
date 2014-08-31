package com.leetcode.trees;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;
import com.leetcode.TreeNode;

public class ConvertSortedListToBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertSortedListToBinarySearchTree test = new ConvertSortedListToBinarySearchTree();
		ListNode head = ListUtil.createList(new int[]{-1,0,1,2});
		TreeNode root = test.sortedListToBST(head, null);
		return;
	}
	/*
	 * 将链表转换为平衡二叉树
	 * 思路还是将链表折半，分成中点，左边，右边三个部分，
	 * 中点作为子树的根节点，左边递归，返回值作为根节点做儿子，右边递归，返回值作为根节点右儿子
	 * 
	 * 
	 */
	
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }
	
    public TreeNode sortedListToBST(ListNode head, ListNode end) {
        if(head == null || head == end) return null;
        if(head.next == end) return new TreeNode(head.val);
        ListNode OStep = head;
        ListNode TStep = head;
        while(TStep != end) {
        	TStep = TStep.next;
        	if(TStep != end) TStep = TStep.next;
        	else break;
        	OStep = OStep.next;
        }
        TreeNode root = new TreeNode(OStep.val);
        TreeNode left = sortedListToBST(head, OStep);
        TreeNode right = sortedListToBST(OStep.next, end);
        root.left = left;
        root.right = right;
        return root;
    }

}



