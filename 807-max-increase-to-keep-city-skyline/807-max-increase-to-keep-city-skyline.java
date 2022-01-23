class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        
        int [] rowMax = new int[grid.length];
        int [] colMax = new int[grid[0].length];
        
        int max = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < grid.length; i++) {
            max = grid[i][j];
            for ( ;j< grid[0].length; j++) {
                max = Math.max(max, grid[i][j]);
            }
            j = 0;
            rowMax[i] = max;
        }
        int i = 0;
        for (j = 0; j < grid[0].length; j++) {
            max = grid[i][j];
            for (; i < grid.length; i++) {
                max = Math.max(max, grid[i][j]);
            }
            i = 0;
            colMax[j] = max;
        }
        
        int result = 0;
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                result += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        
        return result;
    }
}