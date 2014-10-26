package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 iterativePostorder(node)
  parentStack = empty stack  
  lastnodevisited = null 
  while (not parentStack.isEmpty() or node 』 null)
    if (node 』 null)
      parentStack.push(node)
      node = node.left
    else
      peeknode = parentStack.peek()
      if (peeknode.right 』 null and lastnodevisited 』 peeknode.right) 
        // if right child exists AND traversing node from left child, move right //
        node = peeknode.right
      else
        parentStack.pop() 
        visit(peeknode)
        lastnodevisited = peeknode
        
 *
 */
public class PostOrder_BST_iterative {
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> tempStack = new Stack<TreeNode>();
		Stack<TreeNode> retStack = new Stack<TreeNode>();
		List<Integer> ret = new ArrayList<Integer>();
		if (root==null){
			return ret;
		}
		tempStack.push(root);
		while(!tempStack.isEmpty()){
			TreeNode cur = tempStack.pop();
			retStack.push(cur);
			if (cur.left!=null){
				tempStack.push(cur.left);
			}
			if (cur.right!=null){
				tempStack.push(cur.right);
			}
		}
		
		while (!retStack.isEmpty()){
			ret.add(retStack.pop().val);
		}
		return ret;
	}
}
