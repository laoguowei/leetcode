package com.leetcode;

public class ContainerWithMostWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] ={8,10,14,0,13,10,9,9,11,11};
		System.out.print(ContainerWithMostWater.maxArea(a));
	}
  //��̬�滮�����ҵ����ֵ��Ȼ���ҵ����ֵ�ұߵ���Զ�ĵط���Ȼ�������ֵ�����Զ�ĵط���
    public static int maxArea(int[] height) {
    	int midMax = 0;
    	int rightMax = 0;
    	int leftMax = 0;
    	int maxHeight = 0;
    	int maxHeightLoc = 0;
    	int rightMaxLoc = 0;
    	int leftMaxLoc = 0;
    	int i;
    	for(i = 0; i < height.length; i++) {
    		if(height[i] > maxHeight) {
    			maxHeight = height[i];
    			maxHeightLoc = i;
    		}
    	}
    	//��rightMax
    	for(i = maxHeightLoc + 1; i < height.length; i++) {
    		if(height[i] * (i - maxHeightLoc) > rightMax) {
    			rightMax = height[i] * (i - maxHeightLoc);
    			rightMaxLoc = i;
    		}
    	}
    	   	
    	for(i = maxHeightLoc - 1; i >= 0; i--) {
    		if(height[i] * (maxHeightLoc - i) > leftMax) {
    			leftMax = height[i] * (maxHeightLoc - i);
    			leftMaxLoc = i;
    		}
    	}
    	
    	for(i = maxHeightLoc - 1; i >= 0; i--) {
    		int min = height[rightMaxLoc];
    		if(height[i] < height[rightMaxLoc]) {
    			min = height[i];
    		} 
    		if(min * (rightMaxLoc - i) > rightMax) {
    			rightMax = min * (rightMaxLoc - i);
    		}
    	}
    	
    	for(i = maxHeightLoc + 1; i < height.length; i++) {
    		int min = height[leftMaxLoc];
    		if(height[i] < height[leftMaxLoc]) {
    			min = height[i];
    		} 
    		if(min * (i - leftMaxLoc) > leftMax) {
    			leftMax = min * (i - leftMaxLoc);
    		}
    	}

    	return leftMax > rightMax ? leftMax : rightMax;
    }
}
