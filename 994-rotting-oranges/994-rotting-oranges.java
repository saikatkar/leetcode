class Solution {
    public int orangesRotting(int[][] grid) {
        int directions [][] = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int totalFresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    totalFresh ++;
                }
            }
        }
        if (totalFresh == 0) return 0;
        int count = 0;
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes ++;
            while (size -- > 0) {
                int [] arr = queue.poll();
                for (int i = 0; i < directions.length; i++) {
                    int x = arr[0] + directions[i][0];
                    int y = arr[1] + directions[i][1];
                    if (x < 0 || y < 0 || x > m -1 || y > n-1) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        count ++;
                        grid[x][y] = 2; // rot the orange.
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        if (count == totalFresh) {
            return minutes-1;
        } else {
            return -1;
        }
        
    }
}