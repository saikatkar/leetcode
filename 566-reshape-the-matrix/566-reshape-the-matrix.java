class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
         
        int m = mat.length;
        int n = mat[0].length;
        
        if (m*n != r*c) {
            return mat;
        }
        int result[][] = new int[r][c];
        int i1 = 0;
        int j1 = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (j1 == n) {
                    i1++;
                    j1 = 0;
                }
                //System.out.println(Arrays.deepToString(result));
                result[i][j] = mat[i1][j1];
                j1++;
            }
        }
        return result;
    }
}