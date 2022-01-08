class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int dir = 0;
        int k = 1;
        int [][] matrix = new int[n][n];
        
        while (k <= n*n) {
            
            if (dir == 0) {
                for (int i = left; i<=right; i++) {
                    matrix[top][i] = k++;
                }
                top++;
            }
            //System.out.println(result);
            if (dir == 1) {
                for (int i = top; i<=bottom; i++) {
                    matrix[i][right] = k++;
                }
                right--;
            }
            //System.out.println(result);
            if (dir == 2) {
                for (int i = right; i>=left; i--) {
                    matrix[bottom][i] = k++;
                }
                bottom--;
            }
            //System.out.println(result);
            if (dir == 3) {
                for (int i = bottom; i>=top; i--) {
                    matrix[i][left] = k++;
                }
                left++;
            }
            //System.out.println(result);
            dir = (dir+1) % 4;
        }
        return matrix;
    }
}