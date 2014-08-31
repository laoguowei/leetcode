package com.leetcode;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Permutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//permute2(3, 0, new int[3]);
		//permuteUnique2(new int[]{1,1,2});
		return;
	}
	
//    public ArrayList<ArrayList<Integer>> permute(int[] num) {
//        
//    }
    
    public static void permute2(int n, int cur, int[] a) {
    	if(cur == n) {
    		for(int i = 0; i < n; i++) System.out.print(a[i]);
    		System.out.print("\n");
    	}

    	int i = 0;
    	int j = 0;
    	for(i = 1; i <= n; i++) {
        	boolean ok = true;
    		for(j = 0; j < cur; j++) if(a[j] == i) ok = false;
    		if(ok) {
    			a[cur] = i;
    			permute2(n, cur + 1, a);
    		}
    	}
    }
    
//    public static List<List<Integer>> permuteUnique2(int[] num) {
//		ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
//		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
//    	generat(num.length, null, re);
//    	for(int i = 0; i < re.size(); i++) {
//    		ArrayList<Integer> al = re.get(i);
//    		ArrayList<Integer> tmp = new ArrayList<Integer>();
//    		for(int j = 0; j < al.size(); j++) {
//    			tmp.add(num[al.get(j) - 1]);
//    		}
//    		set.add(tmp);
//    	}
//    	return new ArrayList(set);
//    }
    
    public static void generat(int n, ArrayList<Integer> add, ArrayList<ArrayList<Integer>> re) {
    	if(add != null && add.size() == n) {
    		re.add(add);
    		return;
    	}
    	boolean used = false;
    	for(int i = 1; i <= n; i++) {
    		used = false;
    		for(int j = 0; add != null && j < add.size(); j++) {
    			if(i == add.get(j)) {
    				used = true;
    				break;
    			}
    		}
    		if(!used) {
    			ArrayList<Integer> tmp;
    			if(add != null) {
    				tmp = new ArrayList<Integer>(add);
    			} else {
    				tmp = new ArrayList<Integer>();
    			}
    			tmp.add(i);
    			generat(n, tmp, re);
    		}
    	}
    }

}
