class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int result = 0;
        int [][] dp = new int[row+1][col+1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j<=col; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], 
                                                                   dp[i][j-1]));
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result * result;
    }
}