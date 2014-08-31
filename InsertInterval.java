package com.leetcode;

import java.util.ArrayList;

public class InsertInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervals = new ArrayList<InsertInterval.Interval>();
		intervals.add(new Interval(1, 5));
//		intervals.add(new Interval(2, 5));
//		intervals.add(new Interval(6, 7));
//		intervals.add(new Interval(8, 10));
//		intervals.add(new Interval(12, 16));
		insert(intervals, new Interval(2, 7));

	}
	
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        int i = 0;
        int l = 0, r = 0;
        ArrayList<Interval> re = new ArrayList<Interval>();
    	if(intervals.isEmpty()) {
    		re.add(newInterval);
    		return re;
    	}
        int start = newInterval.start;
        int end = newInterval.end;
        for(;i < intervals.size(); i++) {
        	l = intervals.get(i).start;
        	r = intervals.get(i).end;
        	if(start < l) break;
        	else if(start > l && start < r) break;
        	else if(start > r) {
        		re.add(intervals.get(i));
        		continue;
        	}
        }
        
        if(start < l) {
        	for(; i < intervals.size(); i++) {
        		r = intervals.get(i).end;
        		l = intervals.get(i).start; 
        		if(end < l) {
        			re.add(new Interval(start, end));
        			break;
        		} else if(end > l && end < r) {
        			re.add(new Interval(start, r));
        			i++;
        			break;
        		} else {
        			continue;
        		}
        	}
        	
        	for(; i < intervals.size(); i++) {
        		re.add(intervals.get(i));
        	}
        	return re;
        } else if(start > l && start < r) {
        	start = l;
        	for(; i < intervals.size(); i++) {
        		r = intervals.get(i).end;
        		l = intervals.get(i).start; 
        		if(end < l) {
        			re.add(new Interval(start, end));
        			break;
        		} else if(end > l && end < r) {
        			re.add(new Interval(start, r));
        			i++;
        			break;
        		} else if(end > r) {
        			continue;
        		}
        	}
        	
        	for(; i < intervals.size(); i++) {
        		re.add(intervals.get(i));
        	}
        	return re;
        }
        return re;
    }
    
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

}


