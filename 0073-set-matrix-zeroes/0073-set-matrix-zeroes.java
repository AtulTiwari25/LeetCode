class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;       // total rows in matrix
        int col = matrix[0].length;    // total columns in matrix

        // Step 1: Scan the matrix to find zeros
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // If a cell contains 0, mark it with sentinel and mark its row/col
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 10010010; // sentinel value (marker)
                    mark(matrix, i, j);      // mark its row and column
                }
            }
        }

        // Step 2: Convert all marked cells (sentinel values) into actual zeros
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 10010010) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Helper function to mark the row and column of the found zero
    public void mark(int[][] matrix, int x, int y) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Mark all cells in the same column
        for (int i = 0; i < row; i++) {
            if (matrix[i][y] != 0) {
                matrix[i][y] = 10010010; // mark cell
            }
        }

        // Mark all cells in the same row
        for (int j = 0; j < col; j++) {
            if (matrix[x][j] != 0) {
                matrix[x][j] = 10010010; // mark cell
            }
        }
    }
}

