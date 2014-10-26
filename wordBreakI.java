package solution.leetcode.jieGu;

import java.util.Set;

public class wordBreakI {
	public boolean wordBreak_DP(String s, Set<String> dict){
		int s_len = s.length();
		boolean contains[] = new boolean[s_len+1];
		contains[0]=true;
		
		if (dict.isEmpty() || s.isEmpty()){
    		return false;
    	}
    	if (dict.contains(s)){
    		return true;
    	}
    	
    
    	
    	for (int i = 1; i <= s_len; i++){
    		for (int j =0; j<i; j++){
    			String sub = s.substring(j, i);
    			contains[i] = contains[j] && dict.contains(sub);
    			if (contains[i]){
    				break;
    			}
    		}
    	}
    	
    	return contains[s_len];
    	
	}
	
	
	
	
	
	/**
	 * recursive method
	 * @param s
	 * @param dict
	 * @return
	 */
    public boolean wordBreak(String s, Set<String> dict) {
    	if (dict.isEmpty() || s.isEmpty()){
    		return false;
    	}
    	if (dict.contains(s)){
    		return true;
    	}
    	
    	return recHelper(s, dict);
    	
    }
    
    public boolean recHelper(String s, Set<String> dict){
    	if (dict.contains(s)){
    		return true;
    	}
    	int len = s.length();
    	for (int i=0; i<len; i++){
    		String s1 = s.substring(0, i);
    		if (dict.contains(s1)){
    			String s2 = s.substring(i);
    			if (recHelper(s2, dict)){
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
}
