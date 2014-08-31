package com.leetcode;

import java.util.Arrays;

public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num = {1,3,2};
		nextPermutation(num);
	}

    public static void nextPermutation(int[] num) {
        int firstMinus = 0;
        int firstLargerThanM = 0;
        int tmp;
        int i;
        for(i = num.length - 1; i > 0; i-- ) {
        	if(num[i - 1] >= num[i]) continue;
        	break;
        }
        if(i != 0) { //还没到最大值
        	firstMinus = i - 1;
        	for(i = num.length - 1;num[i] <= num[firstMinus] ;i--);
        	firstLargerThanM = i;
        	tmp = num[firstLargerThanM];
        	num[firstLargerThanM] = num[firstMinus];
        	num[firstMinus] = tmp;
        	int begin = firstMinus + 1;
        	int end = num.length - 1;
        	for(;end > begin;end--,begin++) {
        		tmp = num[end];
        		num[end] = num[begin];
        		num[begin] = tmp;
        	}
        	return;
        } else {
        	Arrays.sort(num);
        }
    }
}
