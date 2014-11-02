package solution.leetcode.jieGu;

public class ConvertToBST {
	/**
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST.
	 * 
	 * @param num
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0){
			return null;
		}
		return helper(num, 0, num.length-1);
	}
	
	private TreeNode helper(int[] num, int start, int end){
		int mid = (end-start)/2 +start;
		
		if (start > end){
			return null;
		}
		
		TreeNode root = new TreeNode(num[mid]);
		root.left = helper(num, start, mid-1);
		root.right = helper(num, mid+1, end);
		
		return root;
	}
}
