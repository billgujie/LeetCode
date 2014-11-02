package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	List<String> temp = new ArrayList<String>();
    	if (s==null){
    		return result;
    	}
    	
    	dfs(result, temp, s);
    	return result;
    }
    
    public void dfs(List<List<String>> result, List<String> temp, String s){
    	if (s.length()==0){
    		result.add(new ArrayList<String>(temp));
    		return;
    	}
    	for (int i = 1; i<= s.length(); i++){ //注意边界条件
    		String substr = s.substring(0, i);
    		if (isPalindrome(substr)){
    			temp.add(substr);
    			dfs(result,temp,s.substring(i));
    			temp.remove(temp.size()-1);
    		}
    	}
    }
    
    private boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
