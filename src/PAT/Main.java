package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	Read.init(System.in);
        int n = Read.nextInt();
        int[] a = new int[n+1], b = new int[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = Read.nextInt();
        }
        for (int i=1; i<=n; i++) {
            b[i] = Read.nextInt();
        }
        int p = 2, q;
        while (p <= n && b[p-1] <= b[p]) p++;
        q = p;
        while (p <= n && b[p] == a[p]) p++;
        if (p == n+1) {
            System.out.println("Insertion Sort");
            Arrays.sort(b, 0, q+1);
            System.out.print(b[1]);
            for (int i=2; i<=n; i++)
                System.out.print(" " + b[i]);
        } else {
            System.out.println("Merge Sort");
            int k=1;
            boolean flag=true;
            while (flag) {
            	flag = false;
            	for (int i=1; i<=n; i++) {
            		if (a[i] != b[i]) {
            			flag = true;
            			break;
            		}
            	}
            	k *= 2;
            	for (int i=0; i<n/k; i++) {
            		Arrays.sort(a, 1+i*k, 1+(i+1)*k);
            	}
            	Arrays.sort(a, 1+n/k*k, n+1);
            }
            System.out.print(a[1]);
            for (int i=2; i<=n; i++)
                System.out.print(" " + a[i]);
            
        }
    }

	public static String match(String s, String p) {
		List<String> list = new ArrayList<>();
		System.out.println(list);
		return "cew";
	}

}

class Read {
    static BufferedReader br;
    static StringTokenizer st;

    static void init(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in));
        st = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}