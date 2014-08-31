package com.leetcode;

public class GasStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GasStation gs = new GasStation();
		int[] gas = {1,2,3,3};
		int[] cost  = {2,1,5,1};
		gs.canCompleteCircuit(gas, cost);

	}
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int beginStation = -1;
    	int i ;
    	int j;
    	int cnt;
    	int len = gas.length;
    	int sum = 0;
    	boolean success = true;
    	for(i = 0; i < len;) {
    		cnt = i;
    		sum = 0;
    		success = true;
    		if(gas[i] >= cost[i]) {
    			for(j = 0; j < len ; j++) {
    				sum += (gas[cnt] - cost[cnt]);
    				if(sum < 0) {
    					success = false;
    					break; 					
    				}
    				cnt = ++cnt % len;
    			}
    			if(success) {
    				beginStation = i;
    				break;
    			}
    			if(cnt < i) {
    				break;
    			}
    		}
    		i = cnt + 1;
    	}	
    	return beginStation;
    }

}
