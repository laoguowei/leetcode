package com.leetcode;

public class Sqrt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sqrt s = new Sqrt();
		System.out.println(s.sqrt(1));
	}
	
    public int sqrt(int x) {
    	int left = 0;
    	int right = x;
    	int mid;
    	while(right - left > 0) {
    		mid = (left + right) / 2;
    		if(x/mid > mid) {
    			left = mid;
    		} else if(x/mid < mid) {
    			right = mid;
    		} else {
    			return mid;
    		}
    	}
    	return left;
    }
    
    public double pow(double x, int n) {
    	if(n >0){
            if(n == 1) {
            	return x;
            }
            if(n == 2) {
            	return x*x;
            }
        	if(n % 2 == 0) {
            	double result = pow(x, n / 2);
            	return result * result;
            } else {
            	double result = pow(x, (n - 1) / 2);
            	return result * result * x;
            }
    	} else if(n < 0) {
    		x = 1 / x;
    		n = 0 - n;
            if(n == 1) {
            	return x;
            }
            if(n == 2) {
            	return x*x;
            }
        	if(n % 2 == 0) {
            	double result = pow(x, n / 2);
            	return result * result;
            } else {
            	double result = pow(x, (n - 1) / 2);
            	return result * result * x;
            }
    	} else {
    		return 1;
    	}
    }

}
