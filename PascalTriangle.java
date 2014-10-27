package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	/**
	 * Given numRows, generate the first numRows of Pascal's triangle. For
	 * example, given numRows = 5, Return [ [1], [1,1], [1,2,1], [1,3,3,1],
	 * [1,4,6,4,1] ]
	 * 
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> prev = new ArrayList<Integer>();
		for (int i = 0; i < numRows; i++) {
			if (i >= 2) {
				prev = res.get(i - 1);
			}
			List<Integer> temp = new ArrayList<Integer>(i + 1);
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i) {
					temp.add(1);
				} else {
					int v = prev.get(j - 1) + prev.get(j);
					temp.add(v);
				}
			}
			res.add(temp);
		}
		return res;
	}

	/**
	 * Given an index k, return the kth row of the Pascal's triangle. For
	 * example, given k = 3, Return [1,3,3,1]. Note: Could you optimize your
	 * algorithm to use only O(k) extra space?
	 * 
	 * @param numRows
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < rowIndex+1; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i) {
					temp.add(1);
				} else {
					int v = res.get(j - 1) + res.get(j);
					temp.add(v);
				}
			}
			res=temp;
		}
		return res;
	}
}
