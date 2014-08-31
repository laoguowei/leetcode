package com.leetcode;

import java.util.Arrays;

public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = addBinary("11", "1001");
		return;
	}

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int newLen = j > i ? j + 1: i + 1;
        char[] re = new char[newLen + 1];
        re[0] = 49;
        int carry = 0;
        int cnt = newLen ;
        while(i >= 0 && j >= 0) {
        	int tmpa = a.charAt(i--) -  48;
        	int tmpb = b.charAt(j--) - 48;
        	re[cnt--] = (char) (48 + (tmpa + tmpb + carry) % 2);
        	if(tmpa + tmpb + carry >= 2) carry = 1;
        	else carry = 0;

        }
        while(i >= 0) {
        	int tmpa = a.charAt(i--) -  48;
        	re[cnt--] = (char) (48 + (tmpa + carry) % 2);
        	if(tmpa + carry == 2) carry = 1;
        	else carry = 0;

        }
        while(j >= 0) {
        	int tmpb = b.charAt(j--) -  48;
        	re[cnt--] = (char) (48 + (tmpb + carry) % 2);
        	if(tmpb + carry == 2) carry = 1;
        	else carry = 0;

        }
        if(carry == 1) return new String(re);
        else return new String(Arrays.copyOfRange(re, 1, re.length));
    }
}
