class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean [] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;   
            }
        }
        return count;
    }
    
    private void dfs (int[][] isConnected, boolean [] visited, int i)
    {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j = 0; j < isConnected[0].length; j++) {
            if (i != j && isConnected[i][j] == 1) {
                dfs(isConnected, visited, j);
            }
        }
    }
}