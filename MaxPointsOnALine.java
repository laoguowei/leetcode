package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MaxPointsOnALine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPointsOnALine mp = new MaxPointsOnALine();
		Point p[]= {
		new Point(1, 1),
		new Point(2,2),
		new Point(1, 1),
		new Point(2, 2),
		new Point(3, 3),
//		new Point(5, 20),
//		new Point(2, 8),
//		new Point(3, 12),
//		new Point(4, 16),
		new Point(1, 1)
	};
		mp.maxPoints(p);

	}
    public int maxPoints(Point[] points) {
    	if(points == null || points.length == 0)
    		return 0;
    	double k ;
    	HashMap ks = new HashMap<Double, Integer>();
    	int max = 0;
    	int maxInf = 0;
    	int eq = 0;
    	for(int i = 0; i < points.length; i++) {
    		ks.clear();
    		maxInf = 0;
    		eq = -1;
    		for(int j = 0; j < points.length; j++) {
    			if(points[i].x ==points[j].x) {
    				if(points[i].y ==points[j].y) {
    					eq++;
    				}
    				maxInf++;
    				continue;
    			}
    			k = (points[i].y - points[j].y) / (double)((double)points[i].x - (double)points[j].x);
    			if(!ks.containsKey(k)) {
    				ks.put(k, 1);
    			} else {
    				ks.put(k, (Integer)ks.get(k) + 1);
    			}
    		}
        	Iterator it = ks.entrySet().iterator();
        	while(it.hasNext()) {
        		int tmp = (Integer)((Map.Entry)it.next()).getValue();
        		if(tmp >= max) {
        			max = tmp + 1 + eq;
        		} 
        	}
    		if(maxInf > max) {
    			max = maxInf;
    		}
    	}
    	return max;
    }

}
class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
}
