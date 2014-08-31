package com.leetcode;

public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]b = {{0,0,0},{0,1,0},{0,0,0}};

	}
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int n = obstacleGrid.length;
    	if(n == 0) return 0;
    	int m = obstacleGrid[0].length;
    	return uniquePathsWithObstacles(obstacleGrid, n, m);
    }
	
    public  int uniquePathsWithObstacles(int[][] obstacleGrid, int n, int m) {
        int[][] paths = new int[n][m];
        boolean ifOb = false; 
        for(int i = 0; i < m; i++) {
        	if(!ifOb && obstacleGrid[0][i] != 1) paths[0][i] = 1;
        	else {
        		ifOb = true;
        		paths[0][i] = 0;
        	}
        }
        ifOb = false;
        for(int i = 0; i < n; i++) {
        	if(!ifOb && obstacleGrid[i][0] != 1) paths[i][0] = 1;
        	else {
        		ifOb = true;
        		paths[i][0] = 0;
        	}
        }
        for(int i = 1; i < n; i++) {
        	for(int j = 1; j < m; j++) {
        		if(obstacleGrid[i][j] != 1) paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
        		else paths[i][j] = 0;
        	}
        }
        return paths[n - 1][m - 1];
    }

}
