package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class RestoreIPAddresses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIPAddresses re= new RestoreIPAddresses();
		String s = "123";
		boolean b = s == s.intern();
		String s1 = new String("123");
		boolean b1 = s1==s1.intern();
		System.out.print(b +" " + b1);
	}
    public  HashSet<String> getAll(String s) {
        int size = s.length();
        HashSet<String> set = new HashSet();
        StringBuilder sb;
        for(int i = 1; i < size; i++) {
        	sb = new StringBuilder(s);
        	sb.insert(i, '.');
        	for(int j =1; j < size + 1; j++) {
        		if(j < size + 1 && sb.charAt(j) == '.' || j - 1 >= 1 && sb.charAt(j - 1) == '.') continue;
        		StringBuilder tmp1 = new StringBuilder(sb);
        		tmp1.insert(j, '.');
        		for(int k = 1; k < size + 2; k++) {
            		if(k < size + 2 && tmp1.charAt(k) == '.' || k - 1 >= 1 && tmp1.charAt(k - 1) == '.') continue;
            		StringBuilder tmp2 = new StringBuilder(tmp1);
            		tmp2.insert(k, '.');
            		set.add(tmp2.toString());
        		}
        	}
        }
        return set;
    }
    
    public ArrayList<String> restoreIpAddresses(String s) {
    	ArrayList<String> result = new ArrayList<String>();
    	if(s.length() > 16) return result;
        HashSet <String> set = getAll(s);
        if(set.isEmpty()) return result;
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
        	String cnt =  it.next();
        	String []tmp = cnt.split("\\.");
        	boolean ok = true;
        	for(int i = 0; i <4; i++) {
        		Long id = Long.parseLong(tmp[i]);
        		if(id > 255) ok = false;
        		if(tmp[i].length() > 1) {
        			if(tmp[i].charAt(0) == '0') ok = false;
        		}
        	}
        	if(ok) {
        		result.add(cnt);
        	}
        }
        return result;
    }
}
