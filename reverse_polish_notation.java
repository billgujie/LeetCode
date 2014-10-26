package solution.leetcode.jieGu;

import java.util.Stack;

public class reverse_polish_notation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> memory = new Stack<Integer>();
		int tokens_left = tokens.length;
		if (tokens_left == 1) {
			return toInt(tokens[0]);
		} else if (tokens_left == 0) {
			return 0;
		}
		for (int i = 0; i < tokens_left; i++) {
			try {
				int val = Integer.parseInt(tokens[i]);//this would consider the minus sign: "-4" vs "-"
				memory.push(val);
			} catch (NumberFormatException nfe) {
				int b = memory.pop();
				int a = memory.pop();
				int result = calculate(a, b, tokens[i]);
				memory.push(result);
			}
		}
		return memory.pop();
	}

	public int toInt(String num) {
		return Integer.parseInt(num);
	}

	public int calculate(int a, int b, String op) {
		int ret = 0;
		switch (op) {
		case "*":
			ret = a * b;
			break;
		case "/":
			ret = a / b;
			break;
		case "-":
			ret = a - b;
			break;
		case "+":
			ret = a + b;
			break;
		default:
			break;

		}
		return ret;
	}
}
