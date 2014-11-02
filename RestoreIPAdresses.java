package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAdresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		if (s.length() < 4 || s.length() > 12) {
			return result;
		}
		dfs(result, s, "", 0);
		return result;
		
	}
	
	public void dfs(List<String> result, String s, String temp, int count){
		//base case
		if (count == 3 && isValid(s)){
			result.add(temp+s);
			return;
		}
		if (count >= 3){
			return;
		}
		for (int i = 1; i < 4 && i <s.length(); i++){
			String substr = s.substring(0, i);
			if (isValid(substr)){
				dfs(result, s.substring(i), temp+substr+".",count+1);
			}
		}
		
	}
	
	private boolean isValid(String s){
		if(s.charAt(0)=='0'){
			return s.equals("0");
		}else{
			int n = Integer.parseInt(s);
			return (0<=n && n<=255);
		}
	}
}
