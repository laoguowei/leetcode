package com.leetcode;

public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {5,5,5,6};
		SingleNumber sn = new SingleNumber();
		int i = sn.lengthOfLastWord("Hello World");
		return;
	}
    public int singleNumber(int[] A) {
    	int result = 0;
    	for(int i = 0; i < A.length; i++) {
    		result = A[i] ^ result;
    	}
    	return result;
    }
    
    public int singleNumber2(int[] A) {
    	int[] result = new int[32];
    	for(int i = 0; i < 32; i++) {
    		int tmp = 0;
    		for(int j = 0; j <A.length; j++) {
    			 tmp += (A[j] >> i) & 1;
    		}
    		result[i] = tmp % 3;
    	}
    	int onlyOne = 0;
    	for(int i = 0; i < 32; i++) {
    		onlyOne |= result[i] << i;
    	}
    	return onlyOne;
    }
    
    public static int lengthOfLastWord(String s) {
    	if(s.length() == 0) return 0;
    	int count = 0;
    	if(s.charAt(s.length() - 1) != ' ') {
    		int j;
    		for(j = s.length() - 1; j >= 0; j--) {
    			if(s.charAt(j) == ' ') break;
    			count++;
    		}
    		return count;
    	} else {
    		int j = s.length() - 1;
    		while(j >= 0 && s.charAt(j) == ' ') j--;
    		if(j < 0) return 0;
    		for(;j >=0 && s.charAt(j) != ' '; j--) count++;   	
    		return count;
    	}
    }

}
