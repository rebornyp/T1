package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PermutationCount {

	public static void main(String[] args) {
		int n = 4;
		int k = 4;
		for(int i=1; i<=k; i++)
			System.out.println(getPermutation(n, i));
	}
	
    public static String getPermutation(int n, int k) {
        if(n < 1) return " ";
        k --;
        int mul = 1;
        for(int i=2; i<n; i++) {
        	mul *= i;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=n; i++)
        	list.add(i);
        StringBuilder s = new StringBuilder();
        int r = n-1;
        while(r >= 0) {
        	int index = k / mul;
        	s.append(list.get(index));
        	k %= mul;
        	list.remove(index);
        	if(r > 0)
        		mul /= r;
        	r --;
        }
    	return s.toString();
    }
}
