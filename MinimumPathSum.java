package com.leetcode;
import java.util.*;
public class MinimumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a1.add(1);
		a2.add(3);a2.add(5);
		a3.add(7); a3.add(1);a3.add(10);
		triangle.add(a1);
		triangle.add(a2);
		//triangle.add(a3);
		MinimumPathSum mi = new MinimumPathSum();
		mi.minimumTotal(triangle);
		
		
	}

	
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        return minPathSum(grid, col, row);
    }
	
    public  int minPathSum(int[][] grid, int col, int row) {
        int[][] f = new int[row][col];
        int sum = 0;
        for(int i = 0; i < col; i++) {
        	f[0][i] = grid[0][i] + sum;
        	sum += grid[0][i];
        }
        sum = 0;
        for(int i = 0; i < row; i++) {
        	f[i][0] = grid[i][0] + sum;
        	sum += grid[i][0];
        }
        
        for(int i = 1; i < row; i++) {
        	for(int j = 1; j < col; j++) {
        		int min;
        		min = f[i - 1][j] < f[i][j - 1] ? f[i - 1][j] : f[i][j - 1];
        		f[i][j] = min + grid[i][j];
        	}
        }
        return f[row - 1][col - 1];
    }
    
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	if(triangle.size() == 1) return triangle.get(0).get(0);
    	ArrayList<ArrayList<Integer>> min = new ArrayList<ArrayList<Integer>> ();
    	ArrayList<Integer> tmp = new ArrayList<Integer>();
    	tmp.add(triangle.get(0).get(0));
    	min.add(tmp);
    	for(int i = 1; i < triangle.size() - 1; i++) {
    		ArrayList<Integer> old = min.get(i - 1);
    		ArrayList<Integer> cnt = triangle.get(i);
    		tmp = new ArrayList<Integer>();
    		tmp.add(old.get(0) + cnt.get(0));
    		for(int j = 1; j < old.size(); j++) {   			
    			int minValue = old.get(j) + cnt.get(j) > old.get(j - 1) + cnt.get(j) ? old.get(j - 1) + cnt.get(j) : old.get(j) + cnt.get(j);
    			tmp.add(minValue);				
    		}
    		tmp.add(old.get(old.size() - 1) + cnt.get(cnt.size() - 1));
    		min.add(tmp);
    	}
    	ArrayList<Integer> cnt = triangle.get(triangle.size() - 1);
    	ArrayList<Integer> old = min.get(min.size() - 1);
    	int minRe = 	cnt.get(0) + old.get(0) > cnt.get(cnt.size() - 1) + old.get(old.size() - 1) ? cnt.get(cnt.size() - 1) + old.get(old.size() - 1) : cnt.get(0) + old.get(0); 
    	for(int j = 1; j < old.size(); j++) {
    		int cntMin = old.get(j) + cnt.get(j) > old.get(j - 1) + cnt.get(j) ? old.get(j - 1) + cnt.get(j) : old.get(j) + cnt.get(j);
    		if(cntMin < minRe) minRe = cntMin;
    	}
    	return minRe;
    }

}
