package com.leetcode;
import java.lang.Character.Subset;
import java.util.*;
public class PathSum {

	/**
	 * @param args
	 */
	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSum ps = new PathSum();
		TreeNode root = TreeUtil.createTree("5,4,8,11,#,13,4,7,2,#,#,5,1");
		System.out.println(ps.pathSum(root, 22));
		
	}
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) {
    		return false;
    	}
    	if(root.left == null && root.right == null) {
    		return root.val == sum;
    	}
        boolean hasPath = false;
        if(root.left != null) {
        	hasPath = hasPathSum(root.left, sum - root.val);
        }
        if(hasPath) {
        	return hasPath;
        }
        if(root.right != null) {
        	hasPath = hasPathSum(root.right, sum - root.val);
        }
        return hasPath;
    }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
    	if(root.val == sum) {
    		if(root.left == null && root.right == null) {
    			ArrayList<Integer> tmp = new ArrayList<Integer>();
    			re = new ArrayList<ArrayList<Integer>>();
    			tmp.add(sum);
    			re.add(tmp);
    			return re;
    		}
    		return null;
    	} else {
    		ArrayList<ArrayList<Integer>> l;
    		ArrayList<ArrayList<Integer>> r;
    		if(root.left != null) {  			
    			l = pathSum(root.left, sum - root.val);
    			if(l != null) {
    				for(int i = 0; i < l.size(); i++) {
    					l.get(i).add(root.val);
    					re.add(l.get(i));
    				}
    				
    			}
    		}
    		if(root.right != null) {
    			r = pathSum(root.right, sum - root.val);
    			if(r != null) {
    				for(int i = 0; i < r.size(); i++) {
    					r.get(i).add(root.val);
    					re.add(r.get(i));
    				}
    			}
    		}
    		if(re.isEmpty()) {
    			return null;
    		} else return re;
    	}
 	
    }
    
    public boolean getPathSum(TreeNode root, int sum, ArrayList<Integer> subList, int count) {
    	if(root == null || root.val > sum) {
    		return false;
    	}
    	subList.add(root.val);
    	count++;
    	if(root.left == null && root.right == null) {
    		if(root.val == sum) {
    			list.add(subList);
    			return true;
    		}
    		subList.remove(subList.size() - 1);
    		return false;
    	}
        boolean hasPath = false;
        if(root.left != null) {
        	hasPath = getPathSum(root.left, sum - root.val, subList, count);
        }

        if(root.right != null) {
        	if(hasPath) {
        		subList = new ArrayList<Integer>(subList.subList(0, count));
        		//Collections.copy(list.get(0).subList(0, count), subList)
        	}
        	hasPath = getPathSum(root.right, sum - root.val, subList, count);
         	if(hasPath) {
         		return hasPath;
        	} else {
        		subList.remove(subList.size() - 1);
        	}
        }
        return hasPath;
    }
    
    

}
