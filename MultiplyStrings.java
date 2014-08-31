package com.leetcode;

public class MultiplyStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		multiply("999", "");
	}
	
    public static String multiply(String num1, String num2) {
    	if(num1.isEmpty() && num2.isEmpty()) {
    		return "";
    	}
    	int maxLen = num1.length() > num2.length() ? num1.length() + 1 : num2.length() + 1;
    	char[] s = new char[maxLen];
    	int num1L = num1.length();
    	int num2L = num2.length();
    	int minLen = num1L > num2L ? num2L : num1L;
    	int i = 1;
    	int carry = 0;
    	while(i <=  minLen) {
    		int n1 = num1.charAt(num1L - i) - 48;
    		int n2 = num2.charAt(num2L - i) - 48;
    		char cnt = (char) ((n1 + n2 + carry) % 10 + 48);
    		carry = (n1 + n2 + carry) >= 10 ? 1 : 0;
    		s[maxLen - i] = cnt;
    		i++;
    	}
    	
    	while(i <= num1L) {
    		int n1 = num1.charAt(num1L - i) - 48;
    		char cnt = (char) ((n1 + carry) % 10 + 48);
    		carry = (n1 + carry) >= 10 ? 1 : 0;
    		s[maxLen - i] = cnt;
    		i++;
    	}
    	
    	while(i <= num2L) {
    		int n2 = num2.charAt(num2L - i) - 48;
    		char cnt = (char) ((n2 + carry) % 10 + 48);
    		carry = (n2 + carry) >= 10 ? 1 : 0;
    		s[maxLen - i] = cnt;
    		i++;
    	}
    	if(carry > 0) {
    		s[0] = '1';
    		return new String(s);
    	} else {
    		return new String(s, 1, maxLen - 1);
    	}
    	
    }

}
