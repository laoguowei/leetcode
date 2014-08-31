package com.leetcode;

import java.util.LinkedList;

public class PermutationSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence p = new PermutationSequence();
		System.out.print(p.getPermutation(4,6));

	}
	
    public String getPermutation(int n, int k) {
    	StringBuilder sb = new StringBuilder();
    	LinkedList<Integer> array = new LinkedList<Integer>();
    	for(int i = 1; i <= n; i++) array.addLast(i);
    	getPermutation(sb, array, k);
        return sb.toString();
    }
    
    public void getPermutation(StringBuilder sb, LinkedList array, int k) {
    	if(array.size() == 1) {
    		sb.append(array.getFirst());
    		return;
    	}
    	int gap = computN(array.size() - 1);
    	int index = k / gap;
    	if(k % gap != 0) {
    		sb.append(array.get(index));
    		array.remove(index);
    		getPermutation(sb, array, k - gap*index );
    	} else {
    		sb.append(array.get(index - 1));
    		array.remove(index - 1);
    		getPermutation(sb, array, k - gap*(index - 1));
    	}
    }
    
    private int computN(int n) {
    	if(n == 0) return 1;
    	int sum = 1;
    	for(int i = 1; i <= n; i++) {
    		sum *= i;
    	}
    	return sum;
    }

}
