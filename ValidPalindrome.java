package com.leetcode;

public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPalindrome("a.b,");
	}
	
    public static boolean isPalindrome(String s) {
        char []chars = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while(i < j) {
        	if((chars[i] >= 97 && chars[i] <= 122 || chars[i] >=48 && chars[i] <= 57)
        			&&(chars[j] >= 97 && chars[j] <= 122 || chars[j] >=48 && chars[j] <= 57)) {
        		if(chars[i] == chars[j]) {
        			i++;
        			j--;
        			continue;
        		} else {
        			return false;
        		}		
        	} else {
        		if(chars[i] < 97 && chars[i] > 57 
        				|| chars[i] > 122
        				|| chars[i] < 48) {
        			i++;
        		}
        		if(chars[j] < 97 && chars[j] > 57 
        				|| chars[j] > 122
        				|| chars[j] < 48) {
        			j--;
        		}
        	}
        }
        return true;
    }

}
