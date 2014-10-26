package solution.leetcode.jieGu;

public class CountAndSay {
    public String countAndSay(int n) {
        String seed = "1";//seed get updated every round
        while(--n > 0){
        	StringBuilder sb = new StringBuilder();
        	char[] chars = seed.toCharArray();
        	for (int i = 0; i < chars.length; i++){
        		int count = 1;
        		while (i+1 < chars.length && chars[i] == chars[i+1]){
        			count ++;
        			i++;
        		}
        		sb.append(String.valueOf(count)+String.valueOf(chars[i]));
        	}
        	seed = sb.toString();
        }
        return seed;
    }
}
