package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class PopulatingNextRightPointersinEachNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeUtil.createTree("1,2,2,#,3,3");
		System.out.print(isSymmetric(root));
		
	}
	
    public static void connect(TreeLinkNode root) {
        if(root != null) {       	
        	LinkedList<TreeLinkNode> cntQueue = new LinkedList<TreeLinkNode>();
        	LinkedList<TreeLinkNode> nextQueue = new LinkedList<TreeLinkNode>();
        	LinkedList<TreeLinkNode> tmp;
        	cntQueue.add(root);
        	while(!cntQueue.isEmpty()) {
        		TreeLinkNode t1 = cntQueue.poll();
        		TreeLinkNode t2 = cntQueue.peek();
        		t1.next = t2;
        		if(t1.left != null) nextQueue.add(t1.left);
        		if(t1.right != null) nextQueue.add(t1.right);
        		if(cntQueue.isEmpty()) {
        			tmp = cntQueue;
        			cntQueue = nextQueue;
        			nextQueue = tmp;
        		}
        	}
        	return ;
        }
    }
    
    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    	LinkedList<ArrayList<Integer>> results = new LinkedList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        if(root != null) {
        	LinkedList<TreeNode> cntQueue = new LinkedList<TreeNode>();
        	LinkedList<TreeNode> nextQueue = new LinkedList<TreeNode>();
        	LinkedList<TreeNode> tmp;
        	cntQueue.add(root);
        	ArrayList<Integer> tmpArray = new ArrayList<Integer>();
        	while(!cntQueue.isEmpty()) {
        		TreeNode tmpNode = cntQueue.poll();
        		if(tmpNode.left != null) nextQueue.add(tmpNode.left);
        		if(tmpNode.right != null) nextQueue.add(tmpNode.right);
        		tmpArray.add(tmpNode.val);
        		if(cntQueue.isEmpty()) {
        			tmp = cntQueue;
        			cntQueue = nextQueue;
        			nextQueue = tmp;
        			results.addFirst(tmpArray);
        			tmpArray = new ArrayList<Integer>();
        		}
        	}
        	tmpArray = results.get(0);
        	for(int i = 0; i < results.size(); i++) {
        		re.add(results.get(i));
        	}
        }
        return re;
    }
    
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        if(root != null) {
        	boolean fromLeft = false;
        	LinkedList<TreeNode> cntQueue = new LinkedList<TreeNode>();
        	LinkedList<TreeNode> nextQueue = new LinkedList<TreeNode>();
        	LinkedList<TreeNode> tmp;
        	cntQueue.add(root);
        	ArrayList<Integer> tmpArray = new ArrayList<Integer>();
        	while(!cntQueue.isEmpty()) {
        		TreeNode tmpNode;
        		if(fromLeft) {
        			tmpNode = cntQueue.poll();
            		if(tmpNode.right != null) nextQueue.addFirst(tmpNode.right);   
            		if(tmpNode.left != null) nextQueue.addFirst(tmpNode.left);
        		} else {
        			tmpNode = cntQueue.poll();
            		if(tmpNode.left != null) nextQueue.addFirst(tmpNode.left);
            		if(tmpNode.right != null) nextQueue.addFirst(tmpNode.right);
        		}
        		tmpArray.add(tmpNode.val);
        		if(cntQueue.isEmpty()) {
        			tmp = cntQueue;
        			cntQueue = nextQueue;
        			nextQueue = tmp;
        			re.add(tmpArray);
        			tmpArray = new ArrayList<Integer>();
        			if(fromLeft) {
        				fromLeft = false;
        			} else {
        				fromLeft = true;
        			}
        		}
        	}
        }
        return re;
    }
    
    public static boolean isSymmetric(TreeNode root) {
        if(root != null) {
        	LinkedList cntQueue = new LinkedList();
        	LinkedList nextQueue = new LinkedList();
        	LinkedList tmp;
        	cntQueue.add(root);
        	while(!cntQueue.isEmpty()) {
        		TreeNode tmpNode = (TreeNode)cntQueue.poll();        		
        		if(tmpNode != null) {
        			nextQueue.add(tmpNode.left);
        			nextQueue.add(tmpNode.right);
        		}
        		if(cntQueue.isEmpty() && !nextQueue.isEmpty()) {       			
        			if(nextQueue.size() % 2 != 0) return false;
        			int middle = nextQueue.size() / 2;
        			Stack<TreeNode> stack = new Stack();
        			TreeNode begin = (TreeNode) nextQueue.get(0);
        			Iterator<TreeNode> it = nextQueue.iterator();
        			for(int i = 0; i < nextQueue.size(); i++) {
        				TreeNode tm = it.next();
        				if(i < middle) {
        					stack.push(tm);
        				} else {
        					if(tm == null) {
        						if(stack.peek() != null) return false;
        						stack.pop();
        					} else {
        						if(stack.peek() == null || stack.peek().val != tm.val) return false;
        						stack.pop();
        					}       				
        				}
        			}
        			
        			tmp = cntQueue;
        			cntQueue = nextQueue;
        			nextQueue = tmp;
        		}
        	}
        }
        return true;
    }
}



class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
}
