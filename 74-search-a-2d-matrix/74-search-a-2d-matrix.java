class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length-1;
        int low = 0;
        int high =  matrix.length-1;        
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (matrix[mid][col] < target) {
                low = mid + 1;
            } else if (matrix[mid][0] > target) {
                high = mid-1;
            } else if (matrix[mid][0] < target && matrix[mid][col] > target) {
                return binarySearch(0, col, target, matrix[mid]);
            } else if (matrix[mid][0] == target || matrix[mid][col] == target) {
                return true;
            }   
        }
        return false;
    }
    
    private boolean binarySearch (int low, int high, int target, int [] arr) {
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }  
        }
        return false;
    } 
}