package com.leetcode;

public class TrappingRainWater {

	/**
	 * @param args
	 */
	final static Object ob = new Object();
	private static void TrappingRainWater(){
		
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		trap(new int[]{4,2,3});
	}
	
    public static int trap(int[] A) {
        int sum = 0;
        for(int i = 0; i < A.length;) {
        		int j = i + 1;
                int tmp = 0;
	        	for(;j < A.length; j++) {
	        		if(A[j] < A[i]) {
	        			tmp += A[i] - A[j];
	        			continue;
	        		}
	        		break;
	        	}
	        	if(j < A.length) {
	        		sum += tmp;
	        		i = j;
	        	} else {
	        		i++;
	        	}
        	
        }
        return sum;
    }

}
