class Solution {
    int directions [][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int maxDistance(int[][] grid) {
        Queue<int []> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        if(queue.size()==0 || queue.size() == m*n){
            return -1;
        }
        int dist = -1;
        int maxDist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                int [] temp = queue.poll();
                int i = temp[0];
                int j = temp[1];
                for (int k = 0; k < directions.length; k++) {
                    int x = i + directions[k][0];
                    int y = j + directions[k][1];
                    if (x >= 0 && y >= 0 && x <= m-1 && y <= n-1 && grid[x][y] == 0) {
                        grid[x][y] = -1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            dist ++;
        }
        return dist;
    }
}