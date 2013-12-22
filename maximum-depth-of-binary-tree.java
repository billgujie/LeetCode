/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int maxleft=maxDepth(root.left);
        int maxright=maxDepth(root.right);
        if (maxleft>maxright){
            return maxleft+1;
        }
        else return maxright+1;
    }
}