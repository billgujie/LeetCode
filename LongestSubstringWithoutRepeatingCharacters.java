package solution.leetcode.jieGu;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
        	return 0;
        }
        int left = 0;
        int right = 0;
        int ans = 0;
        Set<Character> set = new HashSet<Character>();
        for (right = 0; right < s.length(); right ++){
        	if (set.add(s.charAt(right))){// its ok, expand right edge
        		ans = Math.max(ans, right - left + 1);
        	}else{
        		while( left< right && s.charAt(left)!=s.charAt(right)){
        			set.remove(s.charAt(left));
        			left++;
        		}
        		left ++;
        	}
        }
        return ans;
    }
}
