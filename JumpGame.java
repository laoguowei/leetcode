package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(reverse(-00));
		//rev(new int[]{1,23,4,5,6,7,84,6,3});
//		TreeNode root1 = TreeUtil.createTree("1,2,3,4,5");
//		TreeNode root2 = TreeUtil.createTree("");
//		boolean b = findRoot(root1, root2);
//		System.out.print(jump(new int[]{2,3,1,1,4}));
		
		//int[][] a = {{1,2,3}};
	//	printMaxi(a);
//		
		//System.out.print(isBST(new int[]{1}, 0, 0));
		//printMaxi(a);
		//spiralOrder(a);
		JumpGame jg = new JumpGame();
		boolean b = jg.canJump2(new int[]{2,3,1,1,4});
		return;
	}
	
    public static boolean canJump(int[] A) {
    	for(int i = 0; i < A.length;){
    		if(i + A[i] >= A.length - 1) return true;
    		if(A[i] == 0) return false;
    		int maxJ = 0;
    		int maxS = 0;
    		int j = i + 1;
    		for(; j < i + A[i]; j++) {
    			int tmp = j - i + A[j];
    			if(tmp > maxJ) {
    				maxJ = j - i + A[j];
    				maxS = j - i;
    			}
    		}
    		if(A[i + A[i]] + A[i] > maxJ) i = i + A[i];
    		else i += maxS;
    	}
    	return true;
    }
    
    public static int jump(int[] A) {
    	int count = 1;
    	for(int i = 0; i < A.length;){
    		if(i + A[i] >= A.length - 1) return count;
    		//if(A[i] == 0) return false;
    		int maxJ = 0;
    		int maxS = 0;
    		int j = i + 1;
    		for(; j < i + A[i]; j++) {
    			int tmp = j - i + A[j];
    			if(tmp > maxJ) {
    				maxJ = j - i + A[j];
    				maxS = j - i;
    			}
    		}
    		if(A[i + A[i]] + A[i] > maxJ) i = i + A[i];
    		else i += maxS;
    		count++;
    	}
    	return count;
    }
    
    public static  int reverse(int x) {
	     boolean posi = false;
	     if(x < 0) posi = true;
	     String tmp = String.valueOf(Math.abs(x));  
	     StringBuilder sb = new StringBuilder(tmp);
	     sb.reverse();
	     int re = Integer.parseInt(sb.toString());
	     return posi ? -re : re;
    }
    
    public static void rev(int[] a) {
    	int begin = 0;
    	int end = a.length - 1;
    	while(begin < end) {
    		while(a[begin] % 2 == 1) begin++;
    		while(a[end] % 2 == 0) end--;
    		if(begin < end) {
    		int tmp = a[begin];
    		a[begin] = a[end];
    		a[end] = tmp;
    		}
    	}
    	return;
    }
    
    public static ArrayList<Integer> grayCode(int n) {
    	HashSet<Integer> appear = new HashSet();
    	ArrayList<Integer> results = new ArrayList<Integer>();
    	results.add(0);
    	appear.add(0);
    	int count = 1;
    	int cnt = 0;
    	int tmp;
    	while(count < 1 << n) {
    		int i = 1;
    		while(true) {
	    		tmp = cnt ^ i;
	    		if(!appear.contains(tmp)) {
	    			appear.add(tmp);
	        		results.add(tmp);
	        		count++;
	        		cnt = tmp;
	        		break;
	    		} else {
	    			i = i << 1;
	    		}
    		}
    	}
    	return results;
    }
    
    public static void recoverTree(TreeNode root) {
        ArrayList<TreeNode> set = new ArrayList<TreeNode>();
        preTr(root, set);
        int tmp = 0;
        TreeNode t1 = null, t2 = null;
        int l = set.size();
        if(l == 2) {
        	tmp = set.get(0).val;
        	set.get(0).val = set.get(1).val;
        	set.get(1).val = tmp;
        	return;
        }
        boolean fi = true;
        for(int i =1; i < l; i++) {
        	if(fi == true) {
        		if(set.get(i).val < set.get(i - 1).val) {
        			t1 = set.get(i - 1);
        			fi = false;
        			continue;
        		}
        	}
        	
        	if(fi == false) {
        		if(set.get(i).val < set.get(i - 1).val) {
        			t2 = set.get(i);
        			break;
        		}
        	}
        	
        }
        if(t1 != null && t2 != null) {
        tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
        }
    }
    
    public static void preTr(TreeNode root, ArrayList<TreeNode> set) {
    	if(root == null) return;
    	
    	preTr(root.left, set);
    	set.add(root);
    	preTr(root.right, set);
    }
    
    public static boolean findRoot(TreeNode r1, TreeNode r2) {
    	boolean same = false;
    	if(r1 != null && r2 != null) {
    		if(r1.val == r2.val) {
    			same = isSame(r1, r2);
    			if(same) return true;
    		} else {
    			if(findRoot(r1.left, r2)) return true;
    			if(findRoot(r1.right, r2)) return true;
    		}
    	} else if(r2 == null) {
    		return true;
    	} 
    	
    	return false;
    	 
    }
    
    public static boolean isSame(TreeNode r1, TreeNode r2) {
    	boolean l;
    	boolean r;
    	if(r1 != null && r2 != null) {
	    	if(r1.val == r2.val) {
	    		l = isSame(r1.left, r2.left);
	    		r = isSame(r1.right, r2.right);
	    		return l & r;
	    	} else {
	    		return false;
	    	}
    	} else if(r2 == null) {
    		return true;
    	} else return false;
    }
    
    public static void printMaxi(int[][] a) {
    	int height = a.length;
    	int with = a[0].length;
    	int ended = height * with;
    	int right = with;
    	int left = 0;
    	int up = 0;
    	int down = height;
    	int i, j, k, l;
    	while(ended > 0) {
    	i = left;
    	for(; i < right && ended > 0; i++,ended--) {
    		System.out.print(a[up][i] + " ");
    	}
    	j = up + 1;
    	i--;
    	for(;j < down && ended > 0; j++,ended--) {
    		System.out.print(a[j][i] + " ");
    	}
    	j--;
    	k = right - 2;
    	for(;k >= left && ended > 0; k--,ended--) {
    		System.out.print(a[j][k] + " ");
    	}
    	l = down - 2;
    	k++;
    	for(;l > up && ended > 0; l--,ended--) {
    		System.out.print(a[l][k] + " ");
    	}
    	up++;
    	left++;
    	right--;
    	down--;
    	}
    	
    	
    	return;
    }
    
    public static ArrayList<Integer> spiralOrder(int[][] a) {
    	ArrayList<Integer> re = new ArrayList<Integer>(); 
    	int height = a.length;
        if(height == 0) return re;
    	int with = a[0].length;
    	int ended = height * with;
    	int[][] b = new int[height][height];
    	int right = with;
    	int left = 0;
    	int up = 0;
    	int down = height;
    	int i, j, k, l;
    	while(ended > 0) {
    	i = left;
    	for(; i < right && ended > 0; i++,ended--) {
    		re.add(a[up][i]);
    	}
    	j = up + 1;
    	i--;
    	for(;j < down && ended > 0; j++,ended--) {
    		re.add(a[j][i]);
    	}
    	j--;
    	k = right - 2;
    	for(;k >= left && ended > 0; k--,ended--) {
    		re.add(a[j][k]);
    	}
    	l = down - 2;
    	k++;
    	for(;l > up && ended > 0; l--,ended--) {
    		re.add(a[l][k]);
    	}
    	up++;
    	left++;
    	right--;
    	down--;
    	}
    	return re;
    }
    
    public static int[][] generateMatrix(int n) {
    	int height = n;
    	int with = height;
    	int ended = 1;
    	int[][] b = new int[height][height];
    	int right = with;
    	int left = 0;
    	int up = 0;
    	int down = height;
    	int i, j, k, l;
    	while(ended <= n * n) {
    	i = left;
    	for(; i < right; i++,ended++) {
    		b[up][i] = ended;
    	}
    	j = up + 1;
    	i--;
    	for(;j < down; j++,ended++) {
    		b[j][i] = ended;
    	}
    	j--;
    	k = right - 2;
    	for(;k >= left; k--,ended++) {
    		b[j][k] = ended;
    	}
    	l = down - 2;
    	k++;
    	for(;l > up; l--,ended++) {
    		b[l][k] = ended;
    	}
    	up++;
    	left++;
    	right--;
    	down--;
    	}
    	return b;
    }
    
  static boolean isPopOrder(int[] push, int[] pop) {
    	Stack<Integer> s = new Stack();
    	int i = 0;
    	int j = 0;
    	while(i < push.length) {
    		if(s.isEmpty()) s.push(push[i++]);
    		while(i < push.length && s.peek() != pop[j]) s.push(push[i++]);
    		if(s.peek() != pop[j]) return false;
    		s.pop();
    		j++;
    	}
    	while(j < pop.length) if(s.pop() != pop[j++]) return false;
    	return true;
    }
  
	
	public static boolean isBST(int[] nodes, int l, int r) {
		if(l <= r) return true;
		int root = nodes[r];
		int i = l;
		while(nodes[i] < root) i++;
		int j = i;
		while(nodes[j] > root) j++;
		if(j == r) {
			return isBST(nodes, l, i - 1) & isBST(nodes, i, r - 1);
		}
		return false;
	}
	
    public boolean canJump2(int[] A) {
    	if(A.length == 1) return true;
    	int i = 0;
    	while(i < A.length) {
    		int longStep = i + A[i];
    		if(longStep >= A.length - 1) return true;
    		int longestJump = A[i + A[i]] + i + A[i];
    		int nextLoc = i + A[i];
    		for(; i < longStep; i++) {
    			if(i + A[i] > longestJump) {
    				longestJump = i + A[i];
    				nextLoc = i;
    			}
    		}
    		i = nextLoc;
    		if(A[i] == 0) return false;
    	}
    	return true;
    }
}

class StackWithMin {
	ArrayList<Integer> stack = new ArrayList<Integer>();
	private int count = 0;
	private int minElement = Integer.MIN_VALUE;
	public void push(int data) {
		if(data < minElement) minElement = data;
		count++;
		stack.add(data);
	}
	
	public int pop() {
		count--;
		return stack.get(count);
	}
	
	public boolean isEmpty() {
		return count > 0;
	}

}
