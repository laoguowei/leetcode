package com.leetcode;

import java.util.ArrayList;

public class BestTimeToBuyAndSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []p = {1,4,2};
		maxProfit(p);
	}
	
    public static int maxProfit(int[] prices) {
    	if(prices == null || prices.length == 0) {
    		return 0;
    	}
    	ArrayList<Integer> profits = new ArrayList<Integer>();
    	int loss = Integer.MIN_VALUE;
    	int anker = 0;
    	int top = 0;
    	boolean up = false;
    	for(int i = 1; i < prices.length; i++) {
    		if(prices[i] > prices[i - 1]) {
    			if(up == false) {
    				if(prices[anker] > prices[i - 1]) anker = i - 1;
    			}
    			up = true;
    			if(i == prices.length - 1) {
    				profits.add(prices[i] - prices[anker]);
    			}
    		} 
    		if(prices[i] <= prices[i - 1]) {
    			if(up) {
    				if(prices[top] > prices[i - 1]) top = i - 1;
    				profits.add(prices[i - 1] - prices[anker]);
    			}
    			up = false;
    		}
    	}
    	
    	if(profits.isEmpty()) {
    		return 0;
    	} else {
    		int max = 0;
    		for(Integer tmp : profits) {
    			if(tmp > max) {
    				max = tmp;
    			}
    		}
    		return max;
    	}
    	
    }
    
    public int maxProfit2(int[] prices) {
        for(int i = prices.length - 1; i > 0; i--) {
        	prices[i] = prices[i] - prices[i - 1];
        }
        int sum = 0;
        for(int i = 1; i < prices.length; i++) {
        	if(prices[i] > 0) {
        		sum += prices[i];
        	}
        }
        return sum;
    }

}
