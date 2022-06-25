class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean [] recStack = new boolean[graph.length];
        boolean [] visited = new boolean[graph.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < recStack.length; i++) {
            if (dfs(graph, i, result, recStack, visited)) {
                result.add(i);
            }
        }
        //Collections.sort(result);
        return result; 
    }
    
    private boolean dfs (int [][] graph, int u,
                      List<Integer> result, boolean [] recStack,
                      boolean [] visited)
    {
        if (recStack[u]) {
            return false;
        }
        if (visited[u]) {
            return true;
        }
        recStack[u] = true;
        visited[u] = true;
        for (int v : graph[u]) {
            if (!dfs (graph, v, result, recStack, visited)) {
                return false;
            }
        }
        recStack[u] = false;
        return true;
    }
}