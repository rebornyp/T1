package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reader {
	static BufferedReader br;
	static StringTokenizer st;
	
	static void init(InputStream input) {
		br = new BufferedReader(new InputStreamReader(input));
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
	
	static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
