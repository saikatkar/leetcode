class Solution {
    public int[] findBall(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        boolean flag = false;
        for (int j = 0; j < grid[0].length; j++) {
            if (j == 3) {
                flag = true;
            }
            dfs(result, 0, j, grid, flag);
            flag = false;
        }
        int [] rslt = new int[result.size()];
        int i =0;
        for (Integer r : result) {
            rslt[i++] = r;
        }
        return rslt;
    }
    
    private void dfs (List<Integer> result, int i, int j, int [][] grid, boolean flag) {
        if (flag) {
            //System.out.println("i: " + i + "j: " + j);
        }
        if (i == grid.length) {
            result.add(j);
            return;
        }
        
        if (j == 0 && grid[i][j] == -1) {
            result.add(-1);
            return;
        }
        if (j == grid[0].length-1 && grid[i][j] == 1) {
            result.add(-1);
            return;
        }
        
        if (j < grid[0].length-1 && grid[i][j] == 1 && grid[i][j+1] == 1) {
        
            dfs(result, i+1, j+1, grid, flag);
        }else if (j > 0 && grid[i][j] == -1 && grid[i][j-1] == -1) {
            dfs(result, i+1, j-1, grid, flag);
        } else {
            result.add(-1);
        }
        
    }
}