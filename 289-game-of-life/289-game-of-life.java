class Solution {
    int directions[][]=new int[][]{{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
    int dead = 2;
    int live = 3;
    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveNeighbors = getLiveNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2) {
                        board[i][j] = dead;
                    }
                    if (liveNeighbors > 3) {
                        board[i][j] = dead;
                    }
                }
                if (board[i][j] == 0) {
                     if (liveNeighbors == 3) {
                        board[i][j] = live;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(board));
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == dead) {
                    board[i][j] = 0;
                }
                
                if (board[i][j] == live) {
                    board[i][j] = 1;
                }
            }
        }
        
    }
    
    private int getLiveNeighbors (int [][] board, int i, int j) {
        int count = 0;
        
        for (int k = 0; k < directions.length; k ++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            if (x < 0 || y < 0 || x > board.length-1 || y > board[0].length-1) {
                continue;
            }
            if (board[x][y] == 1 || board[x][y] == dead) {
                count ++;
            }
        }
        return count;
    }
}