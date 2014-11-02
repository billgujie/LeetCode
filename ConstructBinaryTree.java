package solution.leetcode.jieGu;

public class ConstructBinaryTree {
	/**
	 * Construct Binary Tree from Preorder and Inorder Traversal 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length){
        	return null;
        }
        return PreInHelper(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    private TreeNode PreInHelper(int[] pre, int[] in, int preStart, int inStart, int inEnd){
    	if (preStart > pre.length - 1 || inStart > inEnd){
    		return null;
    	}
    	TreeNode root = new TreeNode(pre[preStart]);
    	int inPos =0;
    	for (int i = inStart ; i <= inEnd; i++){
    		if (in[i] == pre[preStart]){
    			inPos = i;
    		}
    	}
    	
    	//construct left and right
    	root.left = PreInHelper(pre, in, preStart+1, inStart, inPos-1);
    	root.right = PreInHelper(pre, in, preStart+inPos-inStart+1,inPos+1, inEnd);
    	return root;
    }
}
