package solution.leetcode.jieGu;

public class ValidPalindrome {
	public boolean isPalindrome(String s){
		int start = 0;
		int end = s.length()-1;
		String copy = s.toLowerCase();
		while(start < end){
			while(start < end && !isValid(copy.charAt(start))){
				start++;
			}
			while (start < end && !isValid(copy.charAt(end))){
				end--;
			}
			if (copy.charAt(start) != copy.charAt(end)){
				break;
			}else{
				start++;
				end--;
			}
		}
		if (start>=end){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean isValid(char c){
		return (Character.isDigit(c) || Character.isLetter(c));
	}
}
