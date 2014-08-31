package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
	public static TreeNode createTree(String tree) { 
        // {1,2,3,4,#,#,#,5,#,6,#,7,#,8} 
        String[] ss = tree.split(","); 
        return createTree(ss); 
    } 
	
	public static TreeLinkNode createTree2(String tree) { 
        // {1,2,3,4,#,#,#,5,#,6,#,7,#,8} 
        String[] ss = tree.split(","); 
        return createTree2(ss); 
    } 
  
    public static TreeNode createTree(String[] tree) { 
        Queue<TreeNode> q = new LinkedList<TreeNode>(); 
        // 1st one should not be # 
        TreeNode root = constructOne(tree[0]); 
        q.add(root); 
        int idx = 1; 
        while (!q.isEmpty()) { 
              
            TreeNode tn = q.poll(); 
            if (tn == null) { 
                continue; 
            } 
            // construct tn's left&right node 
            // when to stop 
            if (idx == tree.length) { 
                break; 
            } 
            TreeNode left_ = constructOne(tree[idx]); 
            tn.left = left_; 
            q.add(left_); 
            idx++; 
            if (idx == tree.length) { 
                break; 
            } 
            TreeNode right_ = constructOne(tree[idx]); 
            idx++; 
              
              
            tn.right = right_; 
            // add to queue 
            q.add(right_); 
        } 
  
        return root; 
  
    } 
    
    public static TreeLinkNode createTree2(String[] tree) { 
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>(); 
        // 1st one should not be # 
        TreeLinkNode root = constructOne2(tree[0]); 
        q.add(root); 
        int idx = 1; 
        while (!q.isEmpty()) { 
              
        	TreeLinkNode tn = q.poll(); 
            if (tn == null) { 
                continue; 
            } 
            // construct tn's left&right node 
            // when to stop 
            if (idx == tree.length) { 
                break; 
            } 
            TreeLinkNode left_ = constructOne2(tree[idx]); 
            tn.left = left_; 
            q.add(left_); 
            idx++; 
            if (idx == tree.length) { 
                break; 
            } 
            TreeLinkNode right_ = constructOne2(tree[idx]); 
            idx++; 
              
              
            tn.right = right_; 
            // add to queue 
            q.add(right_); 
        } 
  
        return root; 
  
    } 
    
    private static TreeNode constructOne(String s) { 
        if (s.compareTo("#") == 0) { 
            return null; 
        } else { 
            return new TreeNode(Integer.parseInt(s)); 
        } 
    }
    
    private static TreeLinkNode constructOne2(String s) { 
        if (s.compareTo("#") == 0) { 
            return null; 
        } else { 
            return new TreeLinkNode(Integer.parseInt(s)); 
        } 
    }


}
