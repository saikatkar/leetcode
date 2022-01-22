class Solution {
    int [][] directions = new int [][]{{0,1},{0,-1},{1,0},{-1,0}};
    int size = 0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean visited [][] = new boolean[grid.length][grid[0].length];
        int maxSize = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs (visited, grid, i, j);
                    //System.out.println(size);
                    maxSize = Math.max(maxSize, size);
                    size = 0;
                }
            }
        }
        return maxSize;
    }
    
    private void dfs (boolean [][] visited, int [][] grid, int i, int j) {
        
        if (i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1) {
            return;
        }
        
        if (visited[i][j] || grid[i][j] == 0) {
            return;
        }
        
        visited[i][j] = true;
        size ++;
        
        for (int i1 = 0; i1 < directions.length; i1++) {
            int x = i + directions[i1][0];
            int y = j + directions[i1][1];
            dfs(visited, grid, x, y);
        }
    }
}