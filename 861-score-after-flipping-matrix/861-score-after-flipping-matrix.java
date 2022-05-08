class Solution {
    public int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = (grid[i][j] + 1) % 2;        
                }
            }
        }
        int result = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int zero = 0;
            int one = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 0) {
                    zero ++;
                } else {
                    one ++;
                }    
            }
            if (one >= zero) {
                result += one * Math.pow(2, grid[0].length-i-1);
            } else {
                result += zero * Math.pow(2, grid[0].length-i-1);
            }
        }
        return result;
    }
}