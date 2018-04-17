package PAT;

import java.util.Arrays;
import java.util.Scanner;

public class UF {

	private int count;
	private int[] id, size;
	
	public UF(int n) {
		id = new int[n];
		size = new int[n];
		for(int i=0; i<n; i++) {
			id[i] = i;
			size[i] = 1;
		}
		count = n;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		UF test = new UF(n);
		int m = s.nextInt();
		for(int i=0; i<m; i++) {
			int p = s.nextInt();
			int q = s.nextInt();
			if(test.connected(p, q)) continue;
			test.union(p ,q);
		}
		System.out.println(Arrays.toString(test.id));
		System.out.println("分量有" + test.count + "个");
		System.out.println(test.connected(2, 5));
	}

	private void union(int p, int q) {
		int r1 = find(p);
		int r2 = find(q);
		if(r1 == r2) return;
		if(size[r1] < size[r2]) {
			id[r1] = r2;
			if(size[r1] + 1 > size[r2])
				size[r2] += size[r1];
		} else {
			id[r2] = r1;
			if(size[r2] + 1 > size[r1])
				size[r1] = size[r2] + 1;
		}
		count --;
	}

	private boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	private int find(int p) {
		while(p != id[p]) p = id[p];
		return p;
	}

}
