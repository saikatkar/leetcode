class Solution {
    int directions [][] = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int n = rows * cols;
        int [][] result = new int[n][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rCenter, cCenter});
        int k = 0;
        boolean [][] visited = new boolean[rows][cols];
        visited[rCenter][cCenter] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                int [] arr = queue.poll();
                result[k++] = arr;
                for (int i = 0; i < directions.length; i++) {
                    int x = arr[0] + directions[i][0];
                    int y = arr[1] + directions[i][1];
                    if (x < 0 || y < 0 || x > rows-1 || y > cols-1 || visited[x][y]) {
                        continue;
                    }
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return result;
    }
}