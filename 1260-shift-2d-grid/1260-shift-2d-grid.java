class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
        }
        k = k % list.size();
        while (k > 0) {
            list.addFirst(list.removeLast());
            k--;
        }
        //System.out.println(list);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < m*n; i+=n) {
            List<Integer> list1 = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                list1.add(list.get(i+j));
            }
        result.add(list1);
        }
        return result;
    }
}