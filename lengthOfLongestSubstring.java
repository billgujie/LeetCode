package solution.leetcode.jieGu;

public class lengthOfLongestSubstring {
	public int solve(String s) {
        int[] temp = new int[256];
        int maxlen=0;
        int count=0;
        for (int i=0;i<s.length();i++){
        	char c = s.charAt(i);
            //found existed value
            if (temp[c]==1){
                temp= new int[256];
                temp[c]++;
                if (count>maxlen){
                    maxlen=count;
                }
                count=1;
            }else{
                temp[c]++;
                count++;
            }
            
        }
        return maxlen;
    }
	

    
}

