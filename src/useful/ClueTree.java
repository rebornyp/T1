package useful;

import java.util.Arrays;

public class ClueTree {

	public static void main(String[] args) {
		int[] a = {1, 8, 1, 65, 10, 12, 48, 62, 32, 94};
//		System.out.println(Arrays.toString(a));
//		System.out.println(new N().num);
		N n = new N();
		System.out.println(n.getClass());
	}


	
	/**
	 * Trapping Rain Water
	 * @param height
	 * @return             
	 */
	public static int trap(int[] h) {
		if(h == null || h.length <= 2)
			return 0;
        int i = 0, j = h.length - 1, sum = 0, temp = 0;
        while(i < j) {
        	int min = Math.min(h[i], h[j]);
        	if(h[i] < h[j]) {
        		i ++;
        		while(i < j && h[i] < min) {
        			sum += (min - h[i]);
        			i ++;
        		}
        	} else {
        		j --;
        		while(i < j && h[j] < min) {
        			sum += (min - h[j]);
        			j --;
        		}
        	}
        }
		return sum;
    }
	
	public static int firstMissingPositive(int[] a) {
        if(a == null || a.length == 0)
        	return 1;
        for(int i=0; i<a.length; i++) {
        	if(a[i]>0 && a[i]<=a.length && a[i]!=a[a[i] - 1]) {
        		swap(a, i, a[i] - 1);
        		i --;
        	}
        }
        System.out.println(Arrays.toString(a));
        int i;
        for(i=0; i<a.length; i++) {
        	if(a[i] != i + 1)
        		break;
        }
        return i + 1;
    }

	private static void swap(int[] a, int i, int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}
}

class Node {
	static int n = 23;
	static {
		System.out.println(n);
	}
	
	int i = 44;
	{
		System.out.println(3 + "-" + i);
		i = 33;
		System.out.println(3 + "-" + i);
	}
	
	Node() {
		System.out.println(i);
		i = 123;
		System.out.println(i);
	}
	
	static void change() {
		System.out.println("Node is nice to meet you");
	}
}

class N extends Node{
	int age;
	N() {
//		age = 12;
		System.out.println(age);
	}
	
}