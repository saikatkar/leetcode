class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Set<Integer> rowSet = new HashSet<>();
        //Set<Integer> colSet = new HashSet<>();
        
        List<Integer> result = new LinkedList<>();
        
        for (int i = 0; i < m ; i++) {
            int min = matrix[i][0];
            for (int j = 1; j < n; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            rowSet.add(min);
        }
        
        for (int i = 0; i < n ; i++) {
            int max = matrix[0][i];
            for (int j = 1; j < m; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            if (rowSet.contains(max)) {
                result.add(max);
            }
        }
        return result;
    }
}