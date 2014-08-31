package com.leetcode;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {100, 4, 200, 1, 2, 3};
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		System.out.println(lcs.longestConsecutive(a));
		
	}
	
    public int longestConsecutive(int[] num) {
    	if(num.length == 0) {
    		return 0;
    	}
    	HashSet set = new HashSet();
    	for(int i = 0; i < num.length; i++) {
    		set.add(num[i]);
    	}
    	int max = 1;
    	while(!set.isEmpty()) {
    		int cnt = (Integer) set.toArray()[0];
    		int count = 1;
    		int up = cnt + 1;
    		int down = cnt - 1;
    		while(set.contains(up)) {
    			set.remove(up);
    			up++;
    			count++;			
    		}
    		while(set.contains(down)) {
    			set.remove(down);
    			down--;
    			count++;
    		}
    		set.remove(cnt);
    		if(count > max) {
    			max = count;
    		}
    	}
    	return max;
    }

}
