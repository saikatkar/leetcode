class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        int dir = 0;
        
        while (left <= right && top<= bottom) {
            
            if (dir == 0) {
                for (int i = left; i<=right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            }
            //System.out.println(result);
            if (dir == 1) {
                for (int i = top; i<=bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }
            //System.out.println(result);
            if (dir == 2) {
                for (int i = right; i>=left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //System.out.println(result);
            if (dir == 3) {
                for (int i = bottom; i>=top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
            //System.out.println(result);
            dir = (dir+1) % 4;
        }
        return result;
    }
}