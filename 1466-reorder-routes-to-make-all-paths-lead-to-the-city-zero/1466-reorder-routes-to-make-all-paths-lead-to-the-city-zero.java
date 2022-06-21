class Solution {
    int count = 0;
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> udag = createUDAG(connections);
        boolean [] visited = new boolean[n];
        dfs (udag, visited, 0);
        return count;
    }
    
    private void dfs (Map<Integer, List<Integer>> udag, boolean[] visited, int v)
    {
        visited[v] = true;
        for (int i : udag.get(v)) {
            if (!visited[Math.abs(i)]) {
                if (i > 0) {
                    count ++;
                }
                dfs(udag, visited, Math.abs(i));
            }
        }
    }
    
    private Map<Integer, List<Integer>> createUDAG (int[][] connections) 
    {
        Map<Integer, List<Integer>> udag = new HashMap<>();
        for (int[] edge : connections) {
            if (!udag.containsKey(edge[0])) {
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                udag.put(edge[0], list);
            }
            else {
                udag.get(edge[0]).add(edge[1]);
            }
            if (!udag.containsKey(edge[1])) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(-edge[0]);
                udag.put(edge[1], list1);
            } 
            else {
                udag.get(edge[1]).add(-edge[0]);
            }
            
        }
        return udag;
    } 
}