class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        for (int i =0; i< matrix.length; i++) {
            reverse(matrix[i]);
        }
    }
    
    private void transpose (int[][] matrix) {
        int k = 0;
        for (int i = 0; i< matrix.length; i++) {
            for (int j = k; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            k++;
        }
    }
    private void reverse (int [] arr) {
        int i = 0;
        int j = arr.length-1;
        
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;j--;
        }
    }
}