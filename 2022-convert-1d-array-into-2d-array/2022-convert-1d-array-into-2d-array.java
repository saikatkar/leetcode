class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int [][] result = new int[m][n];
        if (m*n != original.length) {
            return new int[][]{};
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[n*i+j];
            }
        }
        return result;
    }
}