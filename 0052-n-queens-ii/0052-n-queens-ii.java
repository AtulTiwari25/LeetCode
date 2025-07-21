class Solution {
    public int totalNQueens(int n) {
        int[] board = createBoard(n); //Board is 1d array
		return search(board, 0);
    }
    
    private static int search(int[] board, int row) {
		if (row == board.length) {
            //Base case, all rows have been searched
			return 1;
		} else {
			int total = 0;
			for (int col = 0; col < board.length; col++) {
				if (isSafeToAddQueenAt(board, row, col)) {
					board[row] = col;
					int result = search(board, row+1);
					total += result;
					board[row] = -1;
				}
			}
			return total;
		}
	}

    private static int[] createBoard(int boardSize) {
		int[] board = new int[boardSize];
		Arrays.fill(board, -1);
		return board;
	}

    public static boolean isSafeToAddQueenAt(int[] boardState, int row, int col) {
		for (int r = 0; r < boardState.length; ++r) {
			if (boardState[r] != -1) {
				int c = boardState[r];
				// is in same row
				if (r == row) {
					// note: we do not check if it is the same column, we return false
					return false;
				}

				// is in same column
				if (c == col) {
					return false;
				}

				// is in same diagonal A
				if (row - r == c - col) {
					return false;
				}

				// is in same diagonal B
				if (row - r == col - c) {
					return false;
				}
			}
		}
		return true;
	}
}