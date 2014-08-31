package com.leetcode;

public class Searcha2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m ={
//		             {1,   3,  5,  7},
//		             {10, 11, 16, 20},
//		             {23, 30, 34, 50},
//		             {51,65,78,99}
				{-10,-10},{-9,-9},{-8,-6},{-4,-2},{0,1},{3,3},{5,5},{6,8}             
		};
		int[] a= {1};
		sortColors(a);
	}
	
    public static boolean searchMatrix(int[][] matrix, int target) {
    	int inCol = 0;
    	int begin = 0;
    	int end = matrix.length - 1;
		int middle = 0;
    	while(begin < end) {
    		middle = (begin + end) / 2;
    		if(target > matrix[middle][matrix[0].length - 1]) begin = middle + 1;
    		else if(target < matrix[middle][matrix[0].length - 1]) end = middle - 1;
    		else return true;
    	}
    	middle = (begin + end) / 2;
    	if(target > matrix[middle][matrix[0].length - 1]) inCol = middle + 1;
    	else inCol = middle;
    	if(inCol >= matrix.length) return false;
    	begin = 0;
    	end = matrix[0].length - 1;
    	while(begin <= end) {
    		middle = (begin + end) /2;
    		if(matrix[inCol][middle] > target) end = middle - 1;
    		else if(matrix[inCol][middle] < target) begin = middle + 1;
    		else {
    			return true;
    		}
    	}
    	return false;
    }
    
    public static void sortColors(int[] A) {
     int c0 = 0;
     int c1 = 0;
     int c2 = 0;
     for(int i = 0; i < A.length ;i++) {
    	 if(A[i] == 0) c0++;
    	 else if(A[i] == 1) c1++;
    	 else c2++;
     }
     for(int i = 0; i < c0; i++) {
    	 A[i] = 0;
     }
     for(int i = c0; i < c0 + c1; i++) {
    	 A[i] = 1;
     }
     for(int i = c1+c0; i < c0+c1+c2; i++) {
    	 A[i] = 2;
     }  
     return;
    }

}
