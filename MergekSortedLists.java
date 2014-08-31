package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {1,4,7,10};
		int []b = {2,5,8,11};
		int []c = {3,6,9,12};
		MergekSortedLists m = new MergekSortedLists();
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
//		lists.add(ListUtil.createList(b));
//		lists.add(ListUtil.createList(a));
//		lists.add(ListUtil.createList(c));
//		lists.add(null);
//		lists.add(null);

		m.mergeKLists(lists);
	}
	
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	if(lists.isEmpty()) return null;
    	if(lists.size() == 1) return lists.get(0);
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new ListNodeComparator());
        for(int i = 0; i < lists.size(); i++) {
        	if(lists.get(i) != null) pq.add(lists.get(i));
        }
        ListNode head = new ListNode(0);
        ListNode cnt = head;
        while(!pq.isEmpty()) {
        	ListNode min = pq.poll();
        	cnt.next = min;
        	cnt = cnt.next;
        	if(min.next != null) {
        		pq.add(min.next);
        	}
        }
        return head.next;
    }

}

class ListNodeComparator implements Comparator<ListNode> {

	@Override
	public int compare(ListNode o1, ListNode o2) {
		// TODO Auto-generated method stub
		if(o1.val < o2.val) return -1;
		else if(o1.val > o2.val) return 1;
		return 0;
	}
	
}
