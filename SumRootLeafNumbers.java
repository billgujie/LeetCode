package solution.leetcode.jieGu;

public class SumRootLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null){
        	return 0;
        }
        return helper(root,0,0);
    }
    
    public int helper(TreeNode node, int path, int sum){
    	if (node == null){
    		return sum;
    	}
    	path = path*10 + node.val;
    	if (node.left == null && node.right == null){
    		sum += path;
    		return sum;
    	}
    	
    	return helper(node.left, path, sum) + helper(node.right, path, sum);
    }
}
