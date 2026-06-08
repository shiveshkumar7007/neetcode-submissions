class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Mark all border-connected O's as safe
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        // Convert surrounded O -> X
        // Restore safe T -> O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int r, int c) {
        int m = board.length;
        int n = board[0].length;

        // Invalid cell or not an O
        if (r < 0 || c < 0 || r >= m || c >= n ||
            board[r][c] != 'O') {
            return;
        }

        // Mark as safe
        board[r][c] = 'T';

        // Visit all 4 directions
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}