package com.leetcode;

import java.util.ArrayList;

public class PascalsTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getRow(0);
	}
	
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
    	if(numRows <= 0) return new ArrayList<ArrayList<Integer>>();;
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> tmp = null;
    	for(int i = 1; i <= numRows; i++) {
    		ArrayList<Integer> cnt = new ArrayList<Integer>();
    		for(int j = 0; j < i ; j++) {
    			if(j == 0 || j == i - 1) {
    				cnt.add(1);
    			}
    			else {
    				cnt.add(tmp.get(j - 1) + tmp.get(j));
    			}
    		}
    		results.add(cnt);
    		tmp = cnt;
    	}
    	return results;
    }
    
    public static ArrayList<Integer> getRow(int rowIndex) {
        int [] tmp = new int[rowIndex + 1];
        int [] cnt = new int[rowIndex + 1];
        int []ex = tmp;
        ArrayList<Integer> c = new ArrayList<Integer>();
    	for(int i = 1; i <= rowIndex + 1; i++) {
    		for(int j = 0; j < i ; j++) {
    			if(j == 0 || j == i - 1) {
    				cnt[j] = 1;
    			}
    			else {
    				cnt[j] = tmp[j - 1] + tmp[j];
    			}
    		}
    		tmp = cnt;
    		cnt = ex;
    		ex = tmp;
    	}
    	for(int i =0; i < rowIndex + 1; i++) {
    		c.add(tmp[i]);
    	}
    	return c;
    }

}
