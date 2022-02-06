class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n; j++) {
                set.add(matrix[i][j]);
            }
            if (set.size() != n) {
                return false;
            }
            set.clear();
        }
        //set.clear();
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n; j++) {
                set.add(matrix[j][i]);
            }
            if (set.size() != n) {
                return false;
            }
            set.clear();
        }
        return true;
    }
}