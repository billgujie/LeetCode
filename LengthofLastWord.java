package solution.leetcode.jieGu;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
    	if (s == null || s.length() == 0){
    		return 0;
    	}
        int size = s.length();
        int i = size-1;
        while (i>=0 && s.charAt(i)==' '){
        	i--;
        }
        int j = i;
        while (j>=0 && s.charAt(j)!=' '){
        	j--;
        }
        return i - j;
    }
}
