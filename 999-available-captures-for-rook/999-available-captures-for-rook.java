class Solution {
    //int directions [][] = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    int count = 0;
    public int numRookCaptures(char[][] board) {
        boolean [][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    dfs(board, i, j, 0);
                    dfs(board, i, j, 1);
                    dfs(board, i, j, 2);
                    dfs(board, i, j, 3);
                }
            }
        }
        return count;
    }
    
     private void dfs (char [][] board, int i, int j, int direction)
    {   
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j>= n || board[i][j] == 'B') {
            return;
        }
        if (board[i][j] == 'p') {
            count ++;
            return;
        }
        if (direction == 0) {
            dfs(board, i-1, j, 0);
        }
        if (direction == 1) {
            dfs(board, i+1, j, 1);
        } 
        if (direction == 2) {
            dfs(board, i, j-1, 2);
        } 
        if (direction == 3) {
            dfs(board, i, j+1, 3);
        }  
    } 
}