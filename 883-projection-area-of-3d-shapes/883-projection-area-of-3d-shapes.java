class Solution {
    public int projectionArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        int nonZeroCount = 0;
        //int i = 0;
        int j = 0;
        for ( int i = 0;i < m; i++) {
            int max = grid[i][j];
            for (; j < n; j++) {
                if (grid[i][j] != 0) {
                    nonZeroCount++;
                }
                max = Math.max(max, grid[i][j]);
            }
            System.out.println(max);
            result += max;
            j = 0;
        }
        
        //i = 0;
        j = 0;
        for (int i = 0;i < n; i++) {
            int max = grid[j][i];
            for (; j < m; j++) {
                max = Math.max(max, grid[j][i]);
            }
            System.out.println(max);
            result += max;
            j = 0;
        }
        
        result += nonZeroCount;
        
        return result;
    }
}