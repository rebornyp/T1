package com;

import java.util.ArrayList;
import java.util.Collections;


public class Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {1, 2, 45, 62, 32};
		int[] b = {21, 12, 5, 2, 3};
		//System.out.println(6 / 1.5);
		System.out.println(getMedian(a, b));
		
	}

	private static float getMedian(int[] a, int[] b) {
		if(a == null || b == null)
			return 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<a.length; i++)
			arr.add(a[i]);
		for(int i=0; i<b.length; i++)
			arr.add(b[i]);
		Collections.sort(arr);
		p(arr);
		int k = arr.size();
		if(k % 2 == 1)
			return arr.get((k + 1) / 2);
		else {
			k = (k + 1) / 2 - 1;
			float f = (arr.get(k) + arr.get(k+1)) / (float)2.0;
			return f;
		}
	}
	
	static void p(ArrayList<Integer> a) {
		System.out.println(a);
	}

}
