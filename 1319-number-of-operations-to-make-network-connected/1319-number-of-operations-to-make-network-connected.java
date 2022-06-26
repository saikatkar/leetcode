class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1) {
            return -1;
        }
        boolean [] visited = new boolean[n];
        Map <Integer, List<Integer>> graph = new HashMap<>();
        for (int [] edge : connections) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                count ++;
            }
        }
        return count-1;
    }
    
    private void dfs (Map<Integer, List<Integer>> graph,
                      int u, boolean [] visited)
    {
        visited[u] = true;
        
        if (graph.containsKey(u)) {
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    dfs(graph, v, visited);    
                }
            }
        }
    }
}