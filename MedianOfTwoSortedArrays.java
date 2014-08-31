package com.leetcode;

public class MedianOfTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
//    public double findMedianSortedArrays(int A[], int B[]) {
//    	double aMid;
//    	double bMid;
//    	if(A.length % 2 ==0) {
//    		aMid = (A[A.length / 2] + A[A.length / 2 - 1]) / 2;
//    	} else {
//    		aMid = A[(A.length - 1) / 2];
//    	}
//    	if(B.length % 2 == 0) {
//    		bMid = (B[B.length / 2] + B[B.length / 2 - 1]) / 2;
//    	} else {
//    		bMid = B[(B.length - 1) / 2];
//    	}
//    	int  bMidLocInA= binarySearch(A, 0, A.length - 1, bMid);
//    	int aMidLocInB = binarySearch(B, 0, B.length - 1, aMid);
//    	//while(bMidLocInA = (A.length + B.length));
//    	
//    	
//    	
//    }
    
    public int binarySearch(int a[], int left, int right, double key) {  //返回的是恰好大于等于key的坐标
    	int mid = (left + right) / 2;
    	while(left < right) {
    		if(a[mid] < key) {
    			left = mid + 1;
    			mid = (left + right) / 2;
    		}
    		else if(a[mid] > key) {
    			right = mid - 1;
    			mid = (right + left) / 2;
    		}
    		else {
    			return mid;
    		}
    	}
    	return left;
    }

}
