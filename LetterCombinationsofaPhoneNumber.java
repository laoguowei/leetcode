package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LetterCombinationsofaPhoneNumber {

	/**
	 * @param args
	 */
	
	private static final HashMap<Integer, ArrayList<Character>> set = new HashMap<Integer, ArrayList<Character>>();
	static {
		for(int i = 0; i <= 9; i++) {
			set.put(i, new ArrayList<Character>());
		}
		Collections.addAll(set.get(0), ' ');
		Collections.addAll(set.get(2), 'a', 'b', 'c');
		Collections.addAll(set.get(3), 'd', 'e', 'f');
		Collections.addAll(set.get(4), 'g', 'h', 'i');
		Collections.addAll(set.get(5), 'j', 'k', 'l');
		Collections.addAll(set.get(6), 'm', 'n', 'o');
		Collections.addAll(set.get(7), 'p', 'q', 'r', 's');
		Collections.addAll(set.get(8), 't', 'u', 'v');
		Collections.addAll(set.get(9), 'w', 'x', 'y', 'z');
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsofaPhoneNumber lc = new LetterCombinationsofaPhoneNumber();
		ArrayList<String> re = lc.letterCombinations("");
		ArrayList<String> t = re;
	}
	
    public ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String>  results = new ArrayList<String> ();
        letterCombinations("", digits.toCharArray(), results);
        return results;
    }
    
    public void letterCombinations(String front, char []end, ArrayList<String> results) {
    	if(end.length == 0) {
    		results.add(new String(""));
    		return;
    	}
        if(end.length == 1) {
        	int tmp = Character.getNumericValue(end[0]);
        	for(int i = 0; i < set.get(tmp).size(); i++) {
        		results.add(front + set.get(tmp).get(i));
        	}
        } else {
        	int tmp = Character.getNumericValue(end[0]);
        	char []nend = Arrays.copyOfRange(end, 1, end.length);
        	for(int i = 0; i < set.get(tmp).size(); i++) {
        		String string = front + set.get(tmp).get(i);
        		letterCombinations(string, nend, results);
        	}
        }
    }

}
