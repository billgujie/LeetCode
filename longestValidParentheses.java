package solution.leetcode.jieGu;

public class longestValidParentheses {
	public int solve(String s) {
		int len = s.length();
		int[] longest = new int[len];
		int result = 0;

		for (int i = 1; i < len; i++) {
			if (s.charAt(i) != ')') { // if its a (, cant be be a pair
				continue;
			}

			int potential_match = i - longest[i - 1] - 1;
			if (potential_match >= 0 && s.charAt(potential_match) == '(') { // check potential match
				int cumulative = potential_match-1 > 0 ? longest[potential_match-1] : 0;
				longest[i] = longest[i-1] + 2 + cumulative;
				result = Math.max(result, longest[i]);	// current result might not always be the biggest: ie: (()))())(
														// expected: 4
			}

		}
		return result;
	}
}
