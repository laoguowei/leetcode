package com.leetcode;

import java.util.ArrayList;

public class SetMatrixZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetMatrixZeroes s = new SetMatrixZeroes();
		int[][] m = {
				{0,0,0,5},
				{4,3,1,4},
				{0,1,1,4},
				{1,2,1,3},
				{0,0,1,1}
		
			};
		s.setZeroes(m);
		}
    public void setZeroes(int[][] matrix) {
        if(matrix != null) {
        	int h = matrix.length;
        	int w = matrix[0].length;
        	setZeroes(matrix, h, w);
        }
    }
    public void setZeroes(int[][] matrix, int heigh, int wide) {
    	ArrayList<ArrayList<Integer>> loc = new ArrayList<ArrayList<Integer>>();
    	for(int i = 0; i < heigh; i++) {
    		for(int j = 0; j < wide; j++) {
    			if(matrix[i][j] == 0) {
    				ArrayList<Integer> tmp = new ArrayList<Integer>();
    				tmp.add(i);
    				tmp.add(j);
    				loc.add(tmp);
    			}
    		}
    	}
    	
    	for(int i = 0; i < loc.size(); i++) {
    		int h = loc.get(i).get(0);
    		int w = loc.get(i).get(1);
    		for(int j = 0; j < wide; j++) {
    			matrix[h][j] = 0;
    		}    		
    		for(int j = 0; j < heigh; j++) {
    			matrix[j][w] = 0;
    		}   		
    	}
    	
    	return ;
    	
    }

}
