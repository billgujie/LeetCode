package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class deepestNode {

	static int maxLevel = 0;
	static TreeNode node = null;

	private static void printLeftUtil(TreeNode root, boolean left, int level) {

		if (root == null)
			return;

		if (left & level > maxLevel) {
			maxLevel = level;
			node = root;
		}

		printLeftUtil(root.left, true, level + 1);
		printLeftUtil(root.right, false, level + 1);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(8);
		root.right.left.right = new TreeNode(9);

		TreeNode res = deepestNode(root);
		

	}
	
	
	public static TreeNode deepestNode(TreeNode root){
		Queue<TreeNode> tmp = new LinkedList<TreeNode>();
		TreeNode res = null;
		tmp.add(root);
		while (!tmp.isEmpty()){
			TreeNode cur = tmp.poll();
			if (cur.left == null && cur.right == null){
				res = cur;
			}
			if(cur.left != null){
				tmp.add(cur.left);
			}
			if(cur.right != null){
				tmp.add(cur.right);
			}
		}
		
		return res;
	}
}