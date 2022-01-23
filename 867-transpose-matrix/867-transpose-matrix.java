class Solution {
    public int[][] transpose(int[][] matrix) {
        int result [][] = new int[matrix[0].length][matrix.length];
        int nr = 0;
        int nc = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[nr][nc] = matrix[i][j];
                nr++;
                if (nr == matrix[0].length) {
                    nc ++;
                    nr = 0;
                }
            }
        }
        return result;
    }
}