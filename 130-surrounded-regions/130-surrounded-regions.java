class Solution {
    int directions[][]=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public void solve(char[][] board) {
        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j<board[0].length; j++) {
                if (i == 0 || j ==0 || i == board.length-1 || j == board[0].length-1 ) {
                    if (board[i][j] == 'O') {
                        dfs (board, i ,j);
                    }
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    private void dfs (char[][] board, int i, int j) {
        
        if (i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1) {
            return;
        }
        
        if (board[i][j] == '#' || board[i][j] == 'X') {
            return;
        }
        
        board[i][j] = '#';
        
        for (int i1 = 0; i1 < directions.length; i1++) {
            int x = i + directions[i1][0];
            int y = j + directions[i1][1];
            dfs(board, x, y);
        }
        
    }
}