package solution.leetcode.jieGu;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() ==0){
        	return 0;
        }
        int[] dp =new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 0;
        if (isValid(s.substring(0, 1))){
        	dp[1]=1;
        }
        for (int i = 2; i < s.length(); i++){
        	if (isValid(s.substring(i-1, i))){
        		dp[i] += dp[i-1];
        	}
        	if (isValid(s.substring(i-2, i))){
        		dp[i] += dp[i-2];
        	}
        }
        
        return dp[s.length()];
        
        
    }
    
    public boolean isValid(String s){
    	if (s.charAt(0)=='0'){
    		return false;
    	}else{
    		int v = Integer.parseInt(s);
    		return v >= 1 && v <=26;
    	}
    }
}
