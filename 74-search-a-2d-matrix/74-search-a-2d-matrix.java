class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        if (matrix[0][0] > target || matrix[matrix.length-1][matrix[0].length-1] < target) {
            return false;
        }
        while (i <= matrix.length-1 && j >=0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
                
            } else {
                i++;
            }
        }
        return false;
    }
}