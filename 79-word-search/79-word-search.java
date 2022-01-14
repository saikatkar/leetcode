class Solution {
    int directions[][]=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    
    public boolean exist(char[][] board, String word)
    {
      boolean visited [][] = new boolean [board.length][board[0].length];  
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
              if (board[i][j] == word.charAt(0)) {
                  if (searchWord(board, i, j, word, 0, visited)) {
                      return true;
                  }
              }
          }
      }
      return false;  
    }
    
    private boolean searchWord (char[][] board,int i, int j, String word, int k, boolean [][] visited)
    { 
       if (!isValid(board.length-1, board[0].length-1, visited, i, j)) {
           return false;
       }
       if (k > word.length()-1) {
           return false;
       } 
       if (word.charAt(k) == board[i][j] && k == word.length() -1) {
           return true;
       }
       if (word.charAt(k) != board[i][j]) {
           return false;
       }
       visited[i][j] = true; 
       //System.out.println(board[i][j]) ;
       for (int i1=0; i1 < directions.length; i1++) {
            int x = i + directions[i1][0];
            int y = j + directions[i1][1];
            if (searchWord(board, x, y, word, k+1, visited)) {
               return true; 
            }
        }
        visited[i][j] = false;
        return false;
    }
    
    private boolean isValid (int row, int col, boolean [][] visited, int i, int j)
    {
        if (i > row || j > col || i < 0 || j < 0 || visited[i][j]) {
            return false;
        }
        return true;
    }
}