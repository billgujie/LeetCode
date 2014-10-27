package solution.leetcode.jieGu;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
        	return false;
        }
        if (root.left == null && root.right == null){
        	return root.val == sum ? true : false;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}
