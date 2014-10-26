package solution.leetcode.jieGu;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if (board.length != 9 || board[0].length != 9) {
			return false;
		}
		// check row, column and block
		for (int i = 0; i < 9; i++) {
			boolean[] mem = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (mem[(int) board[i][j] - '1']) {
						return false;
					}
					mem[(int) board[i][j] - '1'] = true;
				}
			}
		}

		for (int j = 0; j < 9; j++) {
			boolean[] mem = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (mem[(int) board[i][j] - '1']) {
						return false;
					}
					mem[(int) board[i][j] - '1'] = true;
				}
			}
		}

		for (int block = 0; block < 9; block++) {
			boolean[] mem = new boolean[9];
			for (int i = block/3 *3; i < block/3 *3+3; i++) {
				for (int j = block % 3 *3; j < block % 3 *3 + 3; j++) {
					if (board[i][j] != '.'){
						if (mem[(int) board[i][j] - '1']){
							return false;
						}
						mem[(int) board[i][j] - '1'] = true;
					}
				}
			}
		}
		return true;
	}
}
