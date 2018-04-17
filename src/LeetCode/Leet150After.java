package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Leet150After {

	static final int MAX = 100000;  
	static final String[] arr = new String[MAX];  
	  
	public static void main(String[] args) throws Exception {  

		List<String> list = new ArrayList<String>();
		for(int i=0; i<Integer.MAX_VALUE / 2; i++) {
			list.add(String.valueOf(i));
		}
		
		
		
	    /*//为长度为10的Integer数组随机赋值  
	    Integer[] sample = new Integer[10];  
	    Random random = new Random(1000);  
	    for (int i = 0; i < sample.length; i++) {  
	        sample[i] = random.nextInt();  
	    }  
	    //记录程序开始时间  
	    long t = System.currentTimeMillis();  
	    //使用/不使用intern方法为10万个String赋值，值来自于Integer数组的10个数  
        for (int i = 0; i < MAX; i++) {  
            arr[i] = new String(String.valueOf(sample[i % sample.length]));  
//	            arr[i] = new String(String.valueOf(sample[i % sample.length])).intern();  
        }  
        System.out.println((System.currentTimeMillis() - t) + "ms");  
        System.gc();  */
	} 
	
    public static int rotate(int k) {
    	String s = Integer.toBinaryString(k);
        System.out.println(s);
        StringBuilder sb = new StringBuilder();
        int len = s.length()-1;
        for(int i=0; i<32; i++) {
        	if(len >= i)
        		sb.append(s.charAt(len - i));
        	else
        		sb.append("0");
        }
        System.out.println(sb);
        return Integer.parseInt(sb.toString(), 2);
    }
	
    public static String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        List<String> list = new ArrayList<String>();
        for(int i=0; i<nums.length; i++)
        	list.add(Integer.toString(nums[i]));
        Comparator<String> cmp = new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				String t1 = s1 + s2;
				String t2 = s2 + s1;
				return t1.compareTo(t2);
			}
        	
        };
        Collections.sort(list, cmp);
        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1; i>=0; i--)
        	sb.append(list.get(i));
        String temp = sb.toString();
        return temp.matches("0+") ? "0" : temp;
    }
	
    public static int calculateMinimumHP(int[][] d) {
        if(d == null || d.length == 0 || d[0].length == 0) return 0;
        int m = d.length, n = d[0].length;
        for(int i=1; i<m; i++) {
        	d[i][0] += d[i-1][0];
        }
        for(int i=1; i<n; i++) {
        	d[0][i] += d[0][i-1];
        }
        
        for(int i=1; i<m; i++) {
        	for(int j=1; j<n; j++) {
        		d[i][j] = Math.max(d[i-1][j], d[i][j-1]) + d[i][j];
        	}
        }
        return d[m-1][n-1] < 0 ? -d[m-1][n-1] : 0;
    }

}
