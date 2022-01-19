class Solution {
    int [][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[][] updateMatrix(int[][] mat)
    {   int result [][] = new int[mat.length][mat[0].length];
        boolean [][] visited = new boolean[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;    
                }
            }
        }
        int cost = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int idx = 0;
            while (idx < size) {
                int [] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];
                if (mat[i][j] == 1) {
                    result[i][j] = cost;
                }
                
                for (int k = 0 ; k < directions.length; k++) {
                    int x = i + directions[k][0];
                    int y = j + directions[k][1];
                    if (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length &&                              !visited[x][y]) {
                        queue.add(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
                idx ++;
            }
            cost++;
        }
        return result;
    }
}