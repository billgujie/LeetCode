package solution.leetcode.jieGu;

public class balancedBinaryTree {
	//global variable
	public boolean balance = true;
	
    public boolean isBalanced(TreeNode root) {
        
        if (root == null){
        	return true;
        }
        helper(root);
        return balance;
    }
    
    public int helper(TreeNode root){
    	if (root == null){
    		return 0;
    	}
    	
    	if (balance == false){
    		return 0;
    	}
    	
    	int hl = helper(root.left);
    	int hr = helper(root.right);
    	
    	if (Math.abs(hl-hr) > 1){
    		balance = false;
    	}
    	
    	if (balance == false){
    		return 0;
    	}
    	
    	return Math.max(hl, hr)+1;
    }
}
