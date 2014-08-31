package com.leetcode;

public class MaximalRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] matrix= {
				{'1', '1', '1', '0','0'},
				{'1','1','1','1','1'},
				{'1','0','0','0','0'},
				{'1','1','1','1','0'},
				{'1','1','1','1','0'},
				{'1','1','1','1','0'},
				{'1','1','1','1','0'},
				{'1','1','1','1','1'},
				{'1','1','1','1','1'}

		};
		
		maximalRectangle(matrix);

	}
	
    public static int maximalRectangle(char[][] matrix) {
    	if(matrix.length == 0) return 0;
    	int maxArea = 0;
    	for(int i = 0; i < matrix.length; i++) {
    		int cntMaxOne = 0;
    		int l = 0;
    		int r = 0;
    		int cntOne = 0;
    		for(int j = 0; j < matrix[i].length; j++) {
    			if(matrix[i][j] == '0') {
    				if(cntOne > cntMaxOne) {
    					cntMaxOne = cntOne;
    					r = j - 1;
    					l = r - cntMaxOne+1;
    				}
    				cntOne = 0;
    			} else {
    				cntOne++;
    				if(j == matrix[i].length - 1) {
        				if(cntOne > cntMaxOne) {
        					cntMaxOne = cntOne;
        					r = j;
        					l = r - cntMaxOne+1;
        				}
    				}
    			}
    		}
    		
			if(maxArea < cntMaxOne) maxArea = cntMaxOne;
    		
    		if(cntMaxOne == 0) {
    			continue;
    		}
    		boolean ok = true;
    		int h = i + 1;
    		for(; h < matrix.length; h++) {
	    		for(int k = l; k <= r; k++) {
	    			if(matrix[h][k] == '0') ok = false;
	    		}
	    		if(ok == false) {
	    			int tmp = (h - i) * cntMaxOne;
	    			if(tmp > maxArea) maxArea = tmp;
	    			break;
	    		}
    		}
    		if(ok) {
    			int tmp = (h - i) * cntMaxOne;
    			if(tmp > maxArea) maxArea = tmp;
    		}
    	}
    	
    	for(int i = 0; i < matrix[0].length; i++) {
    		int cntMaxOne = 0;
    		int l = 0;
    		int r = 0;
    		int cntOne = 0;
    		for(int j = 0; j < matrix.length; j++) {
    			if(matrix[j][i] == '0') {
    				if(cntOne > cntMaxOne) {
    					cntMaxOne = cntOne;
    					r = j - 1;
    					l = r - cntMaxOne+1;
    				}
    				cntOne = 0;
    			} else {
    				cntOne++;
    				if(j == matrix.length - 1) {
        				if(cntOne > cntMaxOne) {
        					cntMaxOne = cntOne;
        					r = j;
        					l = r - cntMaxOne+1;
        				}
    				}
    			}
    		}
    		
			if(maxArea < cntMaxOne) maxArea = cntMaxOne;
			
    		if(cntMaxOne == 0) {
    			continue;
    		}
    		boolean ok = true;
    		int h = i + 1;
    		for(; h < matrix[0].length; h++) {
	    		for(int k = l; k <= r; k++) {
	    			if(matrix[k][h] == '0') ok = false;
	    		}
	    		if(ok == false) {
	    			int tmp = (h - i) * cntMaxOne;
	    			if(tmp > maxArea) maxArea = tmp;
	    			break;
	    		}
    		}
    		if(ok) {
    			int tmp = (h - i) * cntMaxOne;
    			if(tmp > maxArea) maxArea = tmp;
    		}
    	}
    	
    	return maxArea;
    }
}
