class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean [] visited = new boolean[arr.length];
        if (arr[start] == 0) {
            return true;
        }
        visited[start] = true;
        return dfs(arr, visited, start + arr[start]) ||
            dfs(arr, visited, start - arr[start]);
    }
    
    private boolean dfs(int [] arr, boolean [] visited, int index) {
        if (index < 0 || index > arr.length-1 || visited[index]) {
            return false;
        }
        
        if (arr[index] == 0) {
            return true;
        }
        
        visited[index] = true;
        return dfs(arr, visited, index + arr[index]) ||
            dfs(arr, visited, index - arr[index]);
    }
}