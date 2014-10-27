package solution.leetcode.jieGu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>(); 
    	if (root == null){
    		return res;
    	}
    	
    	queue.add(root);
    	
    	while (!queue.isEmpty()){
    		List<Integer> level = new ArrayList<Integer>();
    		int size = queue.size();
    		for (int i = 0; i < size; i++){
    			TreeNode n = queue.poll();
    			level.add(n.val);
    			if (n.left != null){
    				queue.add(n.left);
    			}
    			if (n.right != null){
    				queue.add(n.right);
    			}
    		}
    		res.add(level);
    	}
    	return res;
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>(); 
    	if (root == null){
    		return res;
    	}
    	
    	queue.add(root);
    	
    	while (!queue.isEmpty()){
    		List<Integer> level = new ArrayList<Integer>();
    		int size = queue.size();
    		for (int i = 0; i < size; i++){
    			TreeNode n = queue.poll();
    			level.add(n.val);
    			if (n.left != null){
    				queue.add(n.left);
    			}
    			if (n.right != null){
    				queue.add(n.right);
    			}
    		}
    		res.add(level);
    	}
    	Collections.reverse(res);
    	return res;
    }
}
