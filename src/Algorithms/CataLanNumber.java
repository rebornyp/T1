package Algorithms;

public class CataLanNumber {

	public static void main(String[] args) {
		int n = 8;
		System.out.println(getCatalan(n));
	}

	private static int getCatalan(int n) {
		if(n < 0)
			return 0;
		int[] arr = new int[n];
		if(n == 1)
			arr[0] = 1;
		if(n == 2) {
			arr[0] = 1;
			arr[1] = 1;
		}
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2; i<n; i++) {
			for(int j=0; j<i; j++) {
				arr[i] += arr[j] * arr[i-j-1];
			}
		}
		return arr[n-1];
	}

}
