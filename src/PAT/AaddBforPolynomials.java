package PAT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AaddBforPolynomials {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] A = s.nextLine().trim().split(" ");
		String[] B = s.nextLine().trim().split(" ");
		s.close();
		Map<Integer, Double> map = new HashMap<>();
		
		int k1 =Integer.parseInt(A[0]);  
	    int k2 =Integer.parseInt(B[0]);
		
		for(int i=1; i<k1*2+1; i +=2)
			map.put(Integer.valueOf(A[i]), Double.valueOf(A[i+1]));
		
		for (int i = 1; i < k2 * 2 + 1; i += 2) {
			int key = Integer.valueOf(B[i]);
			double value = Double.valueOf(B[i + 1]);

			if (map.containsKey(key)) {
				value += map.get(key);
				if (Math.abs(value) <= 0.00001) {
					map.remove(key);
				} else {
					value = Math.round(value * 10) / 10.0;
					map.put(key, value);
				}
			} else {
				value = Math.round(value * 10) / 10.0;
				map.put(key, value);
			}
		}
		Set<Integer> set = map.keySet();
		System.out.print(set.size());
		for(int i : set) {
			System.out.print(" " + i + " " + map.get(i));
		}
		/*List<Integer> list = new ArrayList<Integer>();
		for(int i : set) list.add(i);
		Collections.sort(list);
		Collections.reverse(list);
		System.out.print(list.size());
		for(int i=0; i<list.size(); i++) {
			int j = list.get(i);
			System.out.print(" " + j + " " + map.get(j));
		}*/
		
	}

}
