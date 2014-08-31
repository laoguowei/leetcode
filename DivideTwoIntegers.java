package com.leetcode;

public class DivideTwoIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoIntegers d= new DivideTwoIntegers();
		int[] a = {1, 4};
		int[] i = d.searchRange(a, 4);
	}
	
    public int search(int[] A, int target) {
        int min = searchMin(A);
        if(target <= A[A.length - 1]) {
        	return bSearch(A, target, min, A.length - 1);
        } else {
        	return bSearch(A, target, 0, min - 1);
        }
    }
    
    public int[] searchRange(int[] A, int target) {
        int tmp = bSearch(A, target, 0, A.length - 1);
        if(tmp == -1) return new int[]{-1,-1};
        int[] re = new int[2];
        int l = searchLeft(A, target, 0, A.length - 1);
        int r = searchReft(A, target, 0, A.length - 1);
        re[0] = l;
        re[1] = r;
        return re;
    }
    
    public int searchLeft(int[] A, int target, int begin, int end) {
    	int tmp = bSearch(A, target, begin, end);
    	while(tmp != -1) {
    		if(A[(tmp + begin) / 2] == target) {
    			end = (tmp + begin) / 2 - 1; 
    		} else {
    			begin = (tmp + begin) / 2 + 1;
    		}
    		tmp = bSearch(A, target, begin, end);
    	}
    	return end + 1;
    }
    
    
    public int searchReft(int[] A, int target, int begin, int end) {
    	int tmp = bSearch(A, target, begin, end);
    	while(tmp != -1) {
    		if(A[(tmp + end) / 2] == target) {
    			begin = (tmp + end) / 2 + 1; 
    		} else {
    			end = (tmp + end) / 2 - 1;
    		}
    		tmp = bSearch(A, target, begin, end);
    	}
    	return begin - 1;
    }
    
    public int bSearch(int[] A, int target, int begin, int end) {
    	int l = begin;
    	int r = end;
    	int middle;
    	while(l <= r) {
    		middle = (l + r) / 2;
    		if(A[middle] > target) {
    			r = middle - 1;
    		} else if(A[middle] < target){
    			l = middle + 1;
    		} else {
    			return middle;
    		}
    	}
    	return -1;
    }
    
    public int searchMin(int[] A) {
        int begin = 0;
        int end = A.length - 1;
        int middle;
        if(A[begin] < A[end]) return begin;
        middle = (begin + end) / 2;
        while(begin < end) {
        		middle = (begin + end) / 2;
        		if(A[middle] < A[end]) {
        			if(middle > 0 && A[middle - 1] < A[middle]) {
        				end = middle - 1;
        			}
        			else {
        				return middle;
        			}
        		} else {
        			if(middle < A.length && A[middle] < A[middle + 1]) {
        				begin = middle + 1;
        			} else {
        				return middle + 1;
        			}
        		}
        }
        return begin;
    }
    
//    public int[] searchRange(int[] A, int target) {
//        
//    }
	


}
