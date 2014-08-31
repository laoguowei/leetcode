package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {15,7,11,2};
		int[] ans = TwoSum.twoSum2(num, 9);
		System.out.print(ans[0] + " " + ans[1]);
		//System.out.print(TwoSum.partition(0, 3, num, 16));

	}
	
	
    public static int[] twoSum(int[] numbers, int target) {
    	HashMap<Integer, Integer> map = new HashMap();
    	for(int i = 0; i < numbers.length; i++) {
    		map.put(i + 1, numbers[i]);
    		
    	}
    	Arrays.sort(numbers);
        int toFind;
        int []ans = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while(left != right) {
        	if(numbers[left] + numbers[right] == target) {
        		ans[0] = map.get(numbers[left]);
        		ans[1] = map.get(numbers[right] );
        		}
        	
        	if(numbers[left] + numbers[right] < target && left < right) {
        		left++;
        	}
        	
        	if(numbers[left] + numbers[right] > target && left < right) {
        		right--;
        	}
        }

        return ans;
    }
    
    
    public static int[] twoSum2(int[] numbers, int target) {
    	ArrayList<pairs> list = new ArrayList<pairs>();
    	for(int i = 0; i < numbers.length; i++) {
    		list.add(new pairs(numbers[i], i + 1));
    	}
        Collections.sort(list);
        int left = 0;
        int right = numbers.length - 1;
        int[] ans = new int[2];
        while(left <= right) {
        	if(list.get(left).value + list.get(right).value > target) right--;
        	else if(list.get(left).value + list.get(right).value < target) left ++;
        	else {
        		int tmp1 =list.get(left).loc;
        		int tmp2 = list.get(right).loc;
        		if(tmp1 > tmp2) {
        			ans[0] = tmp2;
        			ans[1] = tmp1;
        		} else {
        			ans[0] = tmp1;
        			ans[1] = tmp2;
        		}
        		break;
        	}
        }
        return ans;
    }

}

class pairs implements Comparable{
	int value;
	int loc;
	public pairs(int v, int l) {
		value = v;
		loc = l;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(value > ((pairs)o).value) return 1;
		else if(value < ((pairs)o).value) return -1;
		else return 0;
	}
}
