class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if ((r == 0 || r == grid.length-1 || c == 0 ||
                    c == grid[0].length-1) && grid[r][c] == 0) {
                    dfs (grid, r, c);
                }
            }
        }
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    int d = dfs(grid, r, c);
                    if (d > 0) {
                        //System.out.println(d);
                        count ++;
                    }
                }
            }
        }
        return count;
    }
    
    private int dfs (int [][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length ||
            c >= grid[0].length || grid[r][c] == 1) {
            return 0;
        }
        grid[r][c] = 1;
        
        return 1 
            + dfs(grid, r+1, c)
            + dfs(grid, r, c+1)
            + dfs(grid, r-1, c)
            + dfs(grid, r, c-1);
        
    }
}