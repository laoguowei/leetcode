package com.leetcode;

public class FirstMissingPositive {

	/**
	 * @param args
	 */

	private static void FirstMissingPositive(int []arr) {
		for(int i = 0; i < arr.length; i++) {
			try {
			if(arr[i] % 2 == 0) throw new NullPointerException();
			else System.out.print(arr[i]);
			} finally {
				System.out.print("e");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//firstMissingPositive(new int[]{1,2,3,4,0,6});
		f(new int[]{1,2,3,4,5});
	}
	
    private static int firstMissingPositive(int[] A) {
    	if(A.length == 0) return 1;
        int i = 0;
        while(i < A.length) {
        	if(A[i] == i) {
        		i++;
        	} else {
        		if(A[i] > 0 && A[i] < A.length && A[i] != A[A[i]]) {
        			int tmp = A[i];
        			A[i] = A[tmp];
        			A[tmp] = tmp;
        		} else {
        			i++;
        		}
        	}
        }
        for(i = 1; i < A.length; i++) {
        	if(A[i] != i) return i;
        }
        return A[0] ==A.length ? A.length + 1 : A.length;
    }//做原地的计数排序
    
    public static int[] f(int[] a) {
    	int []b = new int[a.length];    	
    	int tmp = 1;
    	b[0] = 1;
    	for(int i = 1; i < a.length; i++) {
    		b[i] =b[i - 1] * a[i - 1];
    	}
    	for(int i = a.length - 1; i >= 0; i--) {
    		b[i] = tmp*b[i];
    		tmp *= a[i];
    	}
    	return b;    	
    }

}

