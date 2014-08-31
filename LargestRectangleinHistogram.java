package com.leetcode;

public class LargestRectangleinHistogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//    public int largestRectangleArea(int[] height) {
//    	int max1 = height.length;
//    	int cntMax = 0;
//    	int min = height[0];
//    	int tmp = height[0];
//    	for(int i = 1; i < height.length; i++) {
//    		if(height[i] < min) {
//    			min = height[i];
//    			if(tmp < min * (i + 1)) {
//    				tmp = min*(i + 1);
//    				if(cntMax < tmp) cntMax = tmp;
//    			} else {
//    				tmp = min;
//    			}
//    		} else {
//    			if(height[i] > tmp) {
//    				tmp = height[i];
//    				min = height[i];
//    				if(tmp > cntMax) cntMax = tmp;
//    			} else {
//    				tmp = min*(i + 1);
//    				if(tmp > cntMax) cntMax = tmp;
//    			}
//    		}
//    	}
//    }

}
