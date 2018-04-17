package useful;


public class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println();
		int[] arr = {1, 2, 3, 4};
		change(arr);
		
	}
	

	public static void change(int[] arr) {
		int[] b = arr.clone();
		b[0] = 12;
	}
}
