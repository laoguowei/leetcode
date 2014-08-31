package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class WordBreak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak wb = new WordBreak();
		Set dict = new HashSet();
		dict.add("car");
		dict.add("ca");
		dict.add("rs");
		dict.add("bbbb");
		System.out.print(wb.wordBreak("cars", dict));
	}
	
    public boolean wordBreak(String s, Set<String> dict) {
        boolean ifExist = false;
        HashSet<String> existWords = new HashSet<String> ();
        Iterator<String> it = dict.iterator();
        while(it.hasNext()) {
        	String tmp = it.next();
        	int offset = s.lastIndexOf(tmp);
        	if(offset != -1) {
    			existWords.add(tmp);		
        	}
        }
        
        if(existWords.isEmpty()) {
        	return ifExist;
        } 
        ifExist = findWords(s, existWords);
        return ifExist;
    }
    
    public boolean findWords(String s, HashSet<String> map) {
    	boolean result = false;
    	Iterator<String> it = map.iterator();
    	while(it.hasNext()) {
    		String tmp = it.next();
			if(s.equals(tmp)) {
				return true;
			}
			if(s.length() > tmp.length()) {
				if(s.substring(0, tmp.length()).equals(tmp)) {
	    			String next = s.subSequence(tmp.length(), s.length()).toString();
	    			result = findWords(next, map);
	   				if(result) {
	   					return result;
	   				}
	    		}
			}
    	}
        return result;
    }
}
