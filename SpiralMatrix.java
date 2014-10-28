package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> rst = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return rst;

		int rows = matrix.length;
		int cols = matrix[0].length;
		int count = 0;
		while (count * 2 < rows && count * 2 < cols) {
			for (int i = count; i < cols - count; i++)
				rst.add(matrix[count][i]);

			for (int i = count + 1; i < rows - count; i++)
				rst.add(matrix[i][cols - count - 1]);

			if (rows - 2 * count == 1 || cols - 2 * count == 1) // if only one
																// row /col
																// remains
				break;

			for (int i = cols - count - 2; i >= count; i--)
				rst.add(matrix[rows - count - 1][i]);

			for (int i = rows - count - 2; i >= count + 1; i--)
				rst.add(matrix[i][count]);

			count++;
		}
		return rst;
	}

	/**
	 * Given an integer n, generate a square matrix filled with elements from 1
	 * to n2 in spiral order. For example, Given n = 3, You should return the
	 * following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
	 * 
	 * @param n
	 * @return
	 */
	public int[][] generateMatrix(int n) {
		return null;
	}
}
