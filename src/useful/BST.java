package useful;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 排序二叉树测试类
 * @author Gastby
 *
 */
public class BST {
	
	public static void main(String[] args) {
		int[] arr = {10, 5, 15, 3, 7, 13, 17, 2, 4, 6, 8, 11, 14, 16, 18};
		PrintStream pw = System.out;
		TreeNode root = createBST(arr);

	}

	/**
	 * 删除一个二叉搜索树中任意节点
	 * @param root 二叉树根节点
	 * @param s 所要删除的节点
	 * @return 返回根节点
	 */
	private static TreeNode delete(TreeNode root, TreeNode s) {
		if(s == null)
			return root;
		/*下面采用的是假根节点法，让代码更简洁*/
		TreeNode temp = new TreeNode(-1);
		temp.right = root;
		root.p = temp;
		/*首先判别若要删除节点左右节点都为空的情况*/
		if(s.left == null && s.right == null) {
			if(s == s.p.right)
				s.p.right = null;
			else
				s.p.left = null;
		} else if(s.left == null && s.right != null) { //左子树为空而右子树不为空的情况
			if(s == s.p.right)
				s.p.right = s.right;
			else
				s.p.left = s.right;
			s.right.p = s.p;
		} else if(s.right == null && s.left != null) { //右子树为空而左子树不为空的情况
			if(s == s.p.right)
				s.p.right = s.left;
			else
				s.p.left = s.left;
			s.left.p = s.p;
		} else { //左右子树都不为空的情况
			TreeNode next = nextNode(s); //先找到要删除节点的后驱节点
			/*若后驱结点不是要删除节点的右子树根节点，那可以得出后驱节点左子树一定是空，而且一定不在父节点的右子树上*/
			/*于是先将该节点的父节点和右子树根节点连接，再把该节点右子树替换为要删除节点的右子树，并置替换节点右子树父亲节点为该节点*/
			if(next != s.right) {
				next.p.left = next.right;
				if(next.right != null)
					next.right.p = next.p;
				next.right = s.right;
				s.right.p = next;
			}
			/*判断要删除节点和父亲节点的左右关系，并替换为后驱节点*/
			if(s == s.p.left)
				s.p.left = next;
			else
				s.p.right = next;
			next.p = s.p; //置替换后的节点父亲节点为删除节点父亲节点
			/*处理下与左子树的关系*/
			next.left = s.left;
			s.left.p = next;
		}
		/*将假的头抽走，取出真的root节点*/
		root = temp.right;
		root.p = null;
		return root;
	}

	/**
	 * 查找二叉搜索树中某一节点的前驱节点
	 * @param root 输入要查找的节点
	 * @return 返回要前驱结点，若无则返回null
	 */
	private static TreeNode lastNode(TreeNode root) {
		if(root.left != null)
			return MaxTree(root.left);
		TreeNode temp = root.p;
		while(temp != null && root == temp.left) {
			root = temp;
			temp = temp.p;
		}
		return temp;
	}

	/**
	 * 二叉搜索树的查找算法
	 * @param root 输入节点
	 * @param value 查找的数值
	 * @return 返回该节点引用，没有则返回空
	 */
	private static TreeNode search(TreeNode root, int value) {
		if(root == null || root.val == value)
			return root;
		if(value < root.val)
			return search(root.left, value);
		else
			return search(root.right, value);
	}

	/**
	 * 二叉搜索树里任意一个节点的下一个邻近的节点（数值上来看）也叫后驱节点
	 * @param root 跟节点
	 * @return 返回其引用
	 */
	private static TreeNode nextNode(TreeNode root) {
		if(root.right != null)
			return MinTree(root.right);
		TreeNode temp = root.p;
		while(temp != null && root == temp.right) {
			root = temp;
			temp = temp.p;
		}
		return temp;
	}

	/**
	 * 查找搜索树的最小树节点
	 * @param root
	 * @return
	 */
	private static TreeNode MinTree(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null)
			return null;
		TreeNode temp = root;
		while(temp.left != null)
			temp = temp.left;
		return temp;
	}

	/**
	 * 返回二叉搜索树的最大树节点
	 * @param root 输入根节点
	 * @return
	 */
	private static TreeNode MaxTree(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null)
			return null;
		TreeNode temp = root;
		while(temp.right != null)
			temp = temp.right;
		return temp;
	}

	/**
	 * 前序遍历
	 * @param root 输入根节点
	 */
	private static void preOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.val + "-");
		preOrder(root.left);
		preOrder(root.right);
	}

	/**
	 * 建立一颗二叉搜索树的算法
	 * @param arr 输入参数，一个任意数组
	 * @return 返回该树根节点
	 */
	private static TreeNode createBST(int[] arr) {
		// TODO Auto-generated method stub
		TreeNode root = null;
		if(arr == null || arr.length == 0)
			return root;
		/*Random r = new Random();
		int index = r.nextInt(arr.length);
		int temp = arr[index];
		arr[index] = arr[0];
		arr[0] = temp;*/
		root = new TreeNode(arr[0]);
		for(int i=1; i<arr.length; i++) {
			insertTree(root, arr[i], null);
		}
		return root;
	}

	/**
	 * 二叉搜索树插入一个数值
	 * @param root 待插入二叉搜索树的根节点
	 * @param i 待插入数值
	 * @param p 父节点引用
	 * @return 返回插入后的节点，递归调用
	 */
	private static TreeNode insertTree(TreeNode root, int i, TreeNode p) {
		if(root == null) {
			root = new TreeNode(i);
			root.p = p;
		} else {
			TreeNode pa = root;
			if(i < root.val)
				root.left = insertTree(root.left, i, pa);
			else
				root.right = insertTree(root.right, i, pa);
		}
		return root;
	}

}

/**
 * 这是树算法里的树节点类
 * @author Gastby
 *
 */
class TreeNode {
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TreeNode) {
			TreeNode t = (TreeNode)obj;
			return t.val == val;
		}
		return false;
	}

	/**
	 * val 每个树节点的数值
	 */
	int val;
	
	/**
	 * 父亲节点引用，若无则为null
	 */
	TreeNode p;
	
	/**
	 * 左孩子引用
	 */
	TreeNode left;
	
	/**
	 * 右孩子引用
	 */
	TreeNode right;
	
	/**
	 * 构造函数
	 * @param i 树节点参数值，依次构造整个树节点
	 */
	TreeNode(int i) {
		val = i;
	}

	/**
	 * 重写了该函数，然后将返回该数值
	 */
	public String toString() {
		return "该节点的数值是：" + val;
	}
}