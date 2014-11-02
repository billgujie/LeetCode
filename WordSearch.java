package solution.leetcode.jieGu;

public class WordSearch {
	/**
	 * Given a 2D board and a word, find if the word exists in the grid. The
	 * word can be constructed from letters of sequentially adjacent cell, where
	 * "adjacent" cells are those horizontally or vertically neighboring. The
	 * same letter cell may not be used more than once. For example, Given board
	 * = [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns true, word
	 * = "SEE", -> returns true, word = "ABCB", -> returns false.
	 * 
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || word.isEmpty()){
			return false;
		}
		int row = board.length;
		int col = board[0].length;
		
		for (int i =0; i < row; i++){
			for (int j = 0; j < col; j++){
				if (board[i][j] == word.charAt(0)){
					if (dfs(board, word, i, j, 0)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean dfs(char[][] board, String word, int i, int j, int start){
		if (start == word.length()){
			return true;
		}
		
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)){
			return false;
		}
		
		board[i][j]='*';
		boolean next = dfs(board, word, i-1,j,start+1) || dfs(board, word, i+1,j,start+1) || dfs(board, word, i,j-1,start+1) ||dfs(board, word, i,j+1,start+1);
		board[i][j]= word.charAt(start);
		return next;
	}
}
