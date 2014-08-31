package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int i = lengthOfLongestSubstring("hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac");
		String[] strs = { 
				"abc", "abcd", "abe"
		};
		longestCommonPrefix(strs);
		return;
	}
//	   hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac
//    public boolean isPalindrome(int x) {
//        
//    }
    
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0;
        int counter = 0;
        int max = 0;
        int start = 0;
        while(i < s.length()) {
        	if(!map.containsKey(s.charAt(i))) {
        		map.put(s.charAt(i), i);
        		counter ++;
        	} else {
        		int cnt = map.get(s.charAt(i));
        		if(start > cnt) {
        			counter++;
        		} else if(start == cnt) {
        			start++;
        		} else {
        			start = cnt + 1;
        			if(counter > max) max = counter;
        			counter = i - start + 1;
        		}
        		map.put(s.charAt(i), i);
        	}
        	i++;
        }
        return max > counter ? max : counter;
    }
    
    public static String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0) return "";
    	String tmp = strs[0];
    	if(tmp.length() == 0) return "";
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < tmp.length(); i++) {
    		char cnt = tmp.charAt(i);
    		boolean allSame = true;
    		for(int j = 1; j < strs.length; j++) {
    			if(i < strs[j].length() && strs[j].charAt(i) == cnt) continue;
    			allSame = false;
    			break;
    		}
    		if(allSame) {
    			sb.append(cnt);
    		} else {
    			break;
    		}
    	}
    	return sb.toString();
    }

}
