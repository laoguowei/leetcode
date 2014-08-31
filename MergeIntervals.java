package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeIntervals mi = new MergeIntervals();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(3, 6));
//		intervals.add(new Interval(8, 18));
//		intervals.add(new Interval(15, 18));
		mi.merge(intervals);
		LinkedBlockingQueue lbd = new LinkedBlockingQueue();
	}
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if(intervals.isEmpty()) {
			return intervals;
		}
		if(intervals.size() == 1) {
			return intervals;
		}
		ArrayList<Tag> arrays = new ArrayList<Tag>();
		ArrayList<Interval> result = new ArrayList<Interval>();
		for(int i = 0; i < intervals.size(); i++) {
			Interval in = intervals.get(i);
			Tag start = new Tag(in.start, 0);
			Tag end = new Tag(in.end, 1);
			arrays.add(start);
			arrays.add(end);
		}
		Collections.sort(arrays);
		Stack stack = new Stack();		
		Tag start = arrays.get(0);
		stack.add(start);
		for(int i = 1; i < arrays.size();) {
			Tag tmp = arrays.get(i);
			Tag en;
			if(tmp.side == 0) {
				stack.add(tmp);
			} else {				
				if(i + 1 < arrays.size() && arrays.get(i + 1).num == tmp.num && arrays.get(i + 1).side == 0) {
					i += 2;
					continue;
				} else {
					en = (Tag) stack.pop();
				}
				if(stack.isEmpty()) {
					result.add(new Interval(en.num, tmp.num));
				}
			}
			i++;
		}
		return result;
	}
	
	static class Tag implements Comparable {
		int num;
		int side;
		public Tag(int num, int side) {
			this.num = num;
			this.side = side;
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			if(this.num > ((Tag)o).num) {
				return 1;
			} else if(this.num == ((Tag)o).num) {
				return 0;
			} else {
				return -1;
			}
		}
	}

}

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}
