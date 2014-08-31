package com.leetcode;

public class ReverseWordsInAString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsInAString r = new ReverseWordsInAString();
		String s = r.reverseWords("         the   sky is  blue   ");
		System.out.println(s);
	}
    public String reverseWords(String s) {
    	if(s.trim().isEmpty())
    		return "";
        String[] subs = s.split("\\s+");
        StringBuffer sb = new StringBuffer();
        int end = 0;
        if(subs[0].isEmpty()) {
        	end = 1;
        }
        for(int i = subs.length - 1; i > end; i--) {
        	if(subs[i].isEmpty()) {
        		continue;
        	}
        	sb.append(subs[i] + " ");
        }
        sb.append(subs[end]);

    	return sb.toString();
    }

}
