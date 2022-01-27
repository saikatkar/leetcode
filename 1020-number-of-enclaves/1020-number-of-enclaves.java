class Solution {
    int m = 0;
    int n = 0;
    boolean flag =false;
    int count = 0;
    int result = 0;
    int directions [][] = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean visited [][] = new boolean [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs (grid, visited, i, j);
                    if (!flag) {
                       result += count;  
                    }
                    count = 0;
                    flag = false;
                }
            }
        }
        return result;
    }
    
    private void dfs (int [][] grid, boolean [][] visited, int i, int j)
    {
        if (i < 0 || j < 0 || i > m-1 || j > n-1 || visited[i][j] || grid[i][j] == 0){
            return;
        }
        visited[i][j] = true;
        if (i == 0 || j == 0 || i == m-1 || j == n-1) {
            flag = true;
        } else {
            //System.out.println(i + "...." + j);
            count ++;
        }
        for (int k = 0; k < directions.length; k++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            dfs(grid, visited, x, y);
        }
    }
}