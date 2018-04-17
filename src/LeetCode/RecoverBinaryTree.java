package LeetCode;

public class RecoverBinaryTree {

	public static void main(String[] args) {
		/*int[] a = {12, 7, 18, 9, 15, 13, 1};
		TreeNode h = null;
		for (int i=0; i<a.length; i++)
			h = insert(h, a[i]);
		TreeNode left = h, right = h;
		while (!(left.left == null && right.right == null)) {
			if (left.left != null) left = left.left;
			if (right.right != null) right = right.right;
		}
		left.val = 18;
		right.val = 1;*/
		TreeNode head = new TreeNode(2);
		head.right = new TreeNode(1);
		recoverTree(head);
		mid(head);
	}

	private static TreeNode insert(TreeNode head, int a) {
		if (head == null) return new TreeNode(a); 
		if (a > head.val) head.right = insert(head.right, a);
		else head.left = insert(head.left, a);
		return head;
	}

	private static void mid(TreeNode head) {
		if (head == null) return;
		mid (head.left);
		System.out.println(head.val + " ");
		mid (head.right);
	}

	
	static TreeNode pre, n1, n2;
	public static void recoverTree(TreeNode root) {
		if (root == null)
			return;
		help(root);
		if (n1 != null && n2 != null) {
			int temp = n1.val;
			n1.val = n2.val;
			n2.val = temp;
		}
	}

	static void help(TreeNode root) {
		if (root == null)
			return;
		help(root.left);
		if (pre == null) {
			pre = root;
		} else {
			if (pre.val > root.val) {
				if (n1 == null) n1 = pre;
				n2 = root;
			}
			pre = root;
		}
		help(root.right);

	}
}
