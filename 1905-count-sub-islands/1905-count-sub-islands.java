class Solution {
    int [][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean check = true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    dfs (grid1, grid2, i, j);
                    if (check) {
                        count ++;
                    }
                }
                check = true;
            }
        }
        return count;
    }
    
    private void dfs (int [][] grid1, int grid2[][], int i, int j)
    {
        if (i < 0 || i > grid2.length-1 || j < 0 || j > grid2[0].length-1 || grid2[i][j] == 2 || grid2[i][j] == 0) {
            return;
        }
        grid2[i][j] = 2;
        if (grid1[i][j] != 1) {
            check = false;
        }
        for (int k = 0; k < directions.length; k++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            dfs (grid1, grid2, x, y);
        }
    }
}