public class SurroundedRegions {

	public void solve(char[][] board) {
		int height = board.length;
		int width = board[0].length;

		if (height <= 0 || width <= 0) {
			return;
		}

		int i, j;

		// left most column
		for (i = 0; i < height; i++) {
			if (board[i][0] == 'O') {
				BFS(i, 0, height, width, board);
			}
		}

		// right most column
		for (i = 0; i < height; i++) {
			if (board[i][width - 1] == 'O') {
				BFS(i, width - 1, height, width, board);
			}
		}

		// top most row
		for (i = 0; i < width; i++) {
			if (board[0][i] == 'O') {
				BFS(0, i, height, width, board);
			}
		}

		// bottom most row
		for (i = 0; i < width; i++) {
			if (board[height - 1][i] == 'O') {
				BFS(height - 1, i, height, width, board);
			}
		}

		// reconstruct
		for (i = 0; i < height; i++) {
			for (j = 0; j < width; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}

		for (i = 0; i < height; i++) {
			for (j = 0; j < width; j++) {
				if (board[i][j] == 't') {
					board[i][j] = 'O';
				}
			}
		}

	}

	
	//this BFS method would create runtime error on leetcode when tested with large testcases
	private void doBFSmark(int i, int j, int height, int width, char[][] board) {
		board[i][j] = 't';

		if (i > 0 && board[i - 1][j] == 'O') {
			board[i - 1][j] = 't';
			doBFSmark(i - 1, j, height, width, board);
		}

		if (i < height - 1 && board[i + 1][j] == 'O') {
			board[i + 1][j] = 't';
			doBFSmark(i + 1, j, height, width, board);
		}

		if (j > 0 && board[i][j - 1] == 'O') {
			board[i][j - 1] = 't';
			doBFSmark(i, j - 1, height, width, board);
		}

		if (j < width - 1 && board[i][j + 1] == 'O') {
			board[i][j + 1] = 't';
			doBFSmark(i, j + 1, height, width, board);
		}
	}
	
	//this is another method that would pass the test by implementing the bfs using queue
	private void BFS(int i, int j, int height, int width, char[][] board){
		Queue<Integer> q = new LinkedList<Integer>();
		//q.offer(i*height+j);
		mark(i,j,height,width,board,q);
		while(!q.isEmpty()){
			int index = q.poll();
			int r = index / width;
			int c = index % width;
			
			mark(r-1,c,height,width,board,q);
			mark(r+1,c,height,width,board,q);
			mark(r,c+1,height,width,board,q);
			mark(r,c-1,height,width,board,q);
			
			
		}
		
	}
	
	private void mark(int i,int j, int height, int width, char[][]board, Queue<Integer> q){
		if (i<0 ||i>=height || j<0 || j>=width){
			return;
		}
		if (board[i][j]!='O'){
			return;
		}
		
		board[i][j]='t';
		q.offer(width*i+j);
		return;
	}
	
	
}