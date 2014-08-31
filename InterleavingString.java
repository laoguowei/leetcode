package com.leetcode;

public class InterleavingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
    public  boolean isInterleave(String s1, String s2, String s3) {
    	boolean b1 = isInterleave2(s1,s2,s3);
    	boolean b2 = isInterleave2(s2,s1,s3);
    	return b1 || b2;
    }
	
    public  boolean isInterleave2(String s1, String s2, String s3) {
    	StringBuilder chars1= new StringBuilder();
    	StringBuilder chars2= new StringBuilder();
    	StringBuilder chars3= new StringBuilder(s3);
    	int i = 0;
    	int j = 0;
    	while(i < s1.length() && j < s3.length()) {
    		if(s3.charAt(j) == s1.charAt(i)) {
    			chars3.setCharAt(j, '^');
    			chars1.append(s3.charAt(j));
    			i++;
    		}
    		j++;		
    	}
    	i = 0;
    	j = 0;
    	while(i < s2.length() && j < chars3.length()) {
    		if(chars3.charAt(j) == s2.charAt(i)) {
    			chars2.append(chars3.charAt(j));
    			i++;
    		}
    		j++;		
    	}
    	
    	String ss1 = chars1.toString();
    	String ss2 = chars2.toString();
    	return ss1.equals(s1) & ss2.equals(s2) &(s1.length() + s2.length() == s3.length());
    	
    }

}
