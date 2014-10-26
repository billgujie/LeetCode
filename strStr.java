package solution.leetcode.jieGu;

public class strStr {
	public String strStr(String haystack, String needle) {
		if (needle.isEmpty()){
			return haystack;
		}
		if (haystack.length() < needle.length()){
			return null;
		}
		int haylen = haystack.length();
		int needlen = needle.length();
		for (int i = 0; i < haylen - needlen + 1; i++){
			boolean found = true;
			for (int j = 0; j< needlen; j++){
				if (haystack.charAt(i+j)!=needle.charAt(j)){
					found = false;
					break;
				}
			}
			
			if (found){
				return haystack.substring(i);
			}
		}
		return null;
	}
}
