package com.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class GenerateParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses g = new GenerateParentheses();
		int []a = {1,2,3,4,5};
		ListNode head = ListUtil.createList(a);
		g.removeNthFromEnd(head, 5);
	}

    public ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> results = new ArrayList<String>();
    	Stack s = new Stack();
    	generateParenthesis(n, s, new StringBuilder(), results);
    	return results;
    }
    
    public void generateParenthesis(int n, Stack s, StringBuilder string, ArrayList result) {
    	if(n != 0 || !s.isEmpty()) {
    		if(n == 0) {
    			while(!s.isEmpty()) {
    				string.append(')');
    				s.pop();
    			}
    			result.add(string.toString());
    		}
    		if(n != 0) {
    			Stack tmp = (Stack) s.clone();
    			if(s.isEmpty()) {
    				tmp.push('(');
    				generateParenthesis(n - 1, tmp, new StringBuilder(string).append('('), result);
    			} else {
    				tmp.pop();
    				generateParenthesis(n, tmp, new StringBuilder(string).append(')'), result);
    				tmp.push('(');
    				tmp.push('(');
    				generateParenthesis(n - 1, tmp, new StringBuilder(string).append('('), result);
    			}
    		}
    	} else {
    		result.add(string.toString());
    	}
    }
    
    public boolean isValid(String s) {
    	if(s.length() < 2) return false;
    	char []chars = s.toCharArray();
    	Stack<Character> stack = new Stack<Character>();
    	if(chars[0] != '(' && chars[0] != '[' && chars[0] != '{') return false;
    	stack.push(chars[0]);
    	int i = 1;
    	while(i < s.length()) {
    		if(chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
    			stack.push(chars[i]);
    		} else {
    			if(stack.isEmpty()) return false;
    			char tmp = stack.peek();
    			if(chars[i] ==')' && tmp == '(') stack.pop();
    			else if(chars[i] ==']' && tmp == '[') stack.pop();
    			else if(chars[i] =='}' && tmp == '{') stack.pop();
    			else return false;
    		}
    		i++;
    	}
    	if(stack.isEmpty()) return true;
    	
    	return false;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode begin = head;
    	while(n > 0) {
    		begin = begin.next;
    		n--;
    	}
    	if(begin == null) return head.next;
    	ListNode cnt = head;
    	while(begin.next != null) {
    		begin = begin.next;
    		cnt = cnt.next;		
    	}
    	cnt.next = cnt.next.next;
    	return head;
    }
}
