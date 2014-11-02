package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }
    
    public List<TreeNode> generate(int start, int end){
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	if (start>end){
    		list.add(null);
    		return list;
    	}
    	
    	for (int i = start; i <= end; i++){
    		List<TreeNode> leftsub = generate(start, i-1);
    		List<TreeNode> rightsub = generate(i+1, end);
    		for (TreeNode left: leftsub){
    			for (TreeNode right: rightsub){
    				TreeNode cur = new TreeNode(i);
    				cur.left = left;
    				cur.right = right;
    				list.add(cur);
    			}
    		}
    	}
    	
    	return list;
    }
}
