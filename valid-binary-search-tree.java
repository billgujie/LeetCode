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
    Stack<Integer> sk = new Stack<Integer>();
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        
        inorder(root);
        int pre=sk.pop();
        while(!sk.empty()){
            if(sk.peek()>=pre){
                return false;
            }
            pre=sk.pop();
        }
        return true;
    }
    private void inorder(TreeNode root){
        if (root==null){
            return;
        }
        inorder(root.left);
        sk.push(root.val);
        inorder(root.right);
    }
}