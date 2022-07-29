class Solution {
    int directions[][]=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        char [] wordArr = word.toCharArray();
        boolean [][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (wordArr[0] == board[i][j]) {
                    if (dfs(board, i, j, visited, wordArr, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs (char[][] board, int i, int j,
                         boolean [][] visited, char[] word, int k)
    {
        if (i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1 ||
            visited[i][j]) {
            return false;
        }
        if (k > word.length-1) {
            return false;
        }
        if (k == word.length-1 && word[k] == board[i][j]) {
            return true;
        }
        if (word[k] != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        
        for (int [] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (dfs(board, x, y, visited, word, k+1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}