package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n<=0){
        	return res;
        }
        dfs(res,"",n,n);
        return res;
    }
    /**
     * 1. 如果左括号数还没有用完，那么我们能继续放置左括号
     * 2. 如果已经放置的左括号数大于已经放置的右括号数，那么我们可以放置右括号 （如果放置的右括号数大于放置的左括号数，会出现不合法组合）
     */
    private void dfs(List<String> res, String tmp, int left, int right){
    	
    	if (left == 0 && right == 0){
    		res.add(tmp);
    		return;
    	}
    	if (left > 0){
    		tmp = tmp+"(";
    		dfs(res,tmp,left-1,right);
    		tmp = tmp.substring(0, tmp.length()-1);//back track
    	}
    	if (right > left){
    		tmp = tmp + ")";
    		dfs(res,tmp,left,right-1);
    		tmp = tmp.substring(0, tmp.length()-1);//back track
    	}
    }
}
