
public class TestArray {

	public static void main(String[] args) {
		int[] a = new int[args.length];
		for(int i = 0; i < args.length; i++) {
			a[i] = Integer.parseInt(args[i]);
		}
		print(a);
		System.out.println();
		int k, temp;
		for(int i = 0; i < a.length; i++) {
			k = i;
			for(int j = i + 1; j < a.length; j++) {
				if(a[j] < a[k]) {
					k = j;
				}
				
			}
			if(k != i) {
				temp = a[k];
				a[k] = a[i];
				a[i] = temp;
			}
		}
		print(a);
	}
	private static void print(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
