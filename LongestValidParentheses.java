package com.leetcode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Stack;

public class LongestValidParentheses {

	/**
	 * @param args
	 */
	
	int []a = new int[0];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LongestValidParentheses s =new LongestValidParentheses();
		uniquePaths(8, 3);
	}
	
    public static int uniquePaths(int m, int n) {
        String d = new String("" + 1);
        String u = new String("" + 1);
        BigInteger bi1 = new BigInteger(d);
        BigInteger bi2 = new BigInteger(u);
        for(int i = 1; i <= n - 1; i++) {
        	bi2 = bi2.multiply(new BigInteger("" + i));
        }
        for(int i = m; i <= m + n -2; i++) {
        	bi1 = bi1.multiply(new BigInteger("" + i));
        }
        String re = bi1.divide(bi2).toString();
        return Integer.parseInt(re);
    }
	
    public static int longestValidParentheses(String s) {
    	Stack<Character> stack = new Stack<Character>();
    	int i = 0;
    	int counter = 0;
    	int longest = 0;
    	boolean isContinuous = true;
    	while(i < s.length()) {
    		char tmp = s.charAt(i);
    		if(tmp == '(') {
    			stack.push(tmp);
    			isContinuous = true;
    		}
    		else {
    			if(!stack.isEmpty()) {
    				stack.pop();
    			} else {
    				isContinuous = false;
    			}
    		}
    		if(isContinuous) {
    			counter++;
    		} else {
    			if(longest < counter*2) longest = counter*2;
    		}
    		i++;
    	}
    	return counter * 2;
    }

}
