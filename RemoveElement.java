package com.leetcode;

public class RemoveElement {
	public static void main(String[] args) {
		int []a={1,3,1,4};
		removeElement(a, 1);
	}
    public static int removeElement(int[] A, int elem) {
        int count = 0;
        for(int i = 0; i < A.length; i++) {
        	if(A[i] == elem) continue;
        	A[count++] = A[i];
        }
        return count;
    }
}
