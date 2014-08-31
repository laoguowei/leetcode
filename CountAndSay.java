package com.leetcode;

public class CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountAndSay cas = new CountAndSay();
		System.out.print(cas.countAndSay("1113213211"));
	}
	
    public String countAndSay(int n) {
    	if(n == 1) {
    		return "1";
    	}
    	String tmp = countAndSay("1");
    	for(int i = 2; i < n; i++) {
    		tmp = countAndSay(tmp);
    	}
    	return tmp;
    }
    
    public String countAndSay(String n) {
        char[] nArray = n.toCharArray();
        StringBuilder sb = new StringBuilder();
    	int continuousCnt = 1;
    	if(n.length() > 2) {
    		   for(int i = 0; i < n.length(); i += 2) {        
    	        	if(i + 2 < n.length() && nArray[i] != nArray[i + 1] && nArray[i + 1] != nArray[i + 2]) {
    	        		if(continuousCnt == 1) {
    	            		sb.append(1);
    	            		sb.append(nArray[i]);
    	            		sb.append(1);
    	            		sb.append(nArray[i + 1]);          		
    	        		} else {
    	        			sb.append(continuousCnt);
    	        			sb.append(nArray[i]);
    	        			sb.append(1);
    	        			sb.append(nArray[i + 1]);
    	        			continuousCnt = 1;
    	        		}
    	        		continue;
    	        	} else if(i + 2 < n.length() && nArray[i] != nArray[i + 1] && nArray[i + 1] == nArray[i + 2]) {
    	        		if(continuousCnt == 1) {
        	        		++continuousCnt;
        	        		sb.append(1);
        	        		sb.append(nArray[i]);
        	        		continue;
    	        		} else {
    	        			sb.append(continuousCnt);
    	        			sb.append(nArray[i]);
    	        			continuousCnt = 2;
    	        		}
    	        		continue;
    	        	} else if(i + 2 < n.length() && nArray[i] == nArray[i + 1] && nArray[i + 1] == nArray[i + 2]) {
    	        		continuousCnt += 2;
    	        		continue;
    	        	} else if(i + 2 < n.length() && nArray[i] == nArray[i + 1] && nArray[i + 1] != nArray[i + 2]) { 
    	        		continuousCnt += 1;
    	        		sb.append(continuousCnt);
    	        		continuousCnt = 1;
    	        		sb.append(nArray[i]);
    	        		continue;
    	        	}
    	        	if(i + 2 == n.length()) {
    	        		if(nArray[i] == nArray[i + 1]) {
    	        			if(continuousCnt != 1) {
    	        				sb.append(++continuousCnt);
    	        				sb.append(nArray[i]);
    	        			} else {
        	        			sb.append(2);
        	        			sb.append(nArray[i]);	        				
    	        			}
    	        		} else {
    	        			if(continuousCnt == 1) {
    	        			sb.append(1);
    	        			sb.append(nArray[i]);
    	        			sb.append(1);
    	        			sb.append(nArray[i + 1]); 
    	        			} else {
    	        				sb.append(continuousCnt);
    	        				sb.append(nArray[i]);
    	        				sb.append(1);
        	        			sb.append(nArray[i + 1]); 
    	        			}
    	        			continue;
    	        		}
    	        	}
    	        	if(i == nArray.length - 1) {
    	        		if(continuousCnt == 1) {
    	        			sb.append(1);
    	        			sb.append(nArray[i]);
    	        		} else {
    	        			sb.append(continuousCnt);
    	        			sb.append(nArray[i]);
    	        		}
    	        	}
    		   }
    		} else if(n.length() == 2) {
    			if(nArray[0] == nArray[1]) {
    				sb.append(2);
    				sb.append(nArray[0]);
    			} else {
    				sb.append(1);
    				sb.append(nArray[0]);
    				sb.append(1);
    				sb.append(nArray[1]);
    			}
    		} else {
    			return 1 + n;
    		}
        
        return sb.toString();
    }

}
