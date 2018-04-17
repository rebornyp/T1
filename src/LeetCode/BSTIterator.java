package LeetCode;

public class BSTIterator {

	TreeNode root;
	
	public BSTIterator(TreeNode root) {
        this.root = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	if(root.right != null) return true;
    	return false;
    }

    /** @return the next smallest number */
    public int next() {
//        TreeNode head = root;
        root = getMin(root.right);
        return root.val;
    }
	
    private TreeNode getMin(TreeNode root) {
    	if(root == null) return null;
    	while(root.left != null)
    		root = root.left;
    	return root;
    }
}
