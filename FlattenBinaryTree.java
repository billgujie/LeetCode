package solution.leetcode.jieGu;

import java.util.Stack;

public class FlattenBinaryTree {
	//pre order flatten, iterative
    public void flatten(TreeNode root) {
        if (root == null){
        	return;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode p = null;
        while(p != null || !stack.isEmpty()){
        	TreeNode curr = stack.pop();
        	if (curr.right !=null){
        		stack.push(curr.right);
        	}
        	if (curr.left != null){
        		stack.push(curr.left);
        	}
        	if (p != null){
        		p.left = null;
        		p.right = curr;
        	}
        	p = curr;
        }
    }
}
