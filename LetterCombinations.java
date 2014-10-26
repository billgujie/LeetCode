package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
	public List<String> LetterCombination(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		if (digits == null) {
			return result;
		}

		Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
		
		
		StringBuilder sb = new StringBuilder();
		// int size = digits.length();
		recursiveHelper(map, result, sb, digits);
		return result;
	}

	private void recursiveHelper(Map<Character, char[]> map,
			ArrayList<String> result, StringBuilder sb, String digits) {
		if (sb.length() == digits.length()){
			result.add(sb.toString());
			return;
		}
		char[] values = map.get(digits.charAt(sb.length()));
		for (char c : values){ //sb length = 0
			sb.append(c);
			recursiveHelper(map, result, sb, digits);
			sb.deleteCharAt(sb.length()-1); //back track
		}
	}

}
