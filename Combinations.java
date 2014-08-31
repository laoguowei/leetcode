package com.leetcode;

import java.util.ArrayList;

public class Combinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations c= new Combinations();
		c.combine(5, 2);

	}
	
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> add = new ArrayList<Integer>();
    	combine(n, k, add, re);
    	return re;
    }
	
    public void combine(int n, int k, ArrayList<Integer> add, ArrayList<ArrayList<Integer>> re) {
    	if(add.size() == k) {
    		re.add(new ArrayList<Integer>(add));
    	}
    	for(int j = 1; j <= n; j++) {
      		boolean avl = true;
    		for(int i = 0; i < add.size(); i++) {
      			if(add.get(i) == j) {
      				avl = false;
      				break;
      			}
      			if(j < add.get(i)) {
      				avl = false;
      				break;
      			}
   			}
    		if(avl) {
    			add.add(j);
    			combine(n, k, add,re);
    			add.remove(add.size() - 1);
    		}
   		}
    }

}
