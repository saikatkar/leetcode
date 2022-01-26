class Solution {
    int n = 0;
    public int snakesAndLadders (int[][] board) {
        this.n = board.length;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        for (int i = 1; i<= n*n; i++) {
            int [] arr = getPos(i);
            //System.out.println(Arrays.toString(arr));
            if (board[arr[0]][arr[1]] != -1) {
                map.put(i, board[arr[0]][arr[1]]);
            }
        }
        
        queue.add(1);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                //System.out.println("size ***** " + size);
                int pos = queue.poll();
                if (set.contains(pos)) {
                    continue;
                }
                //System.out.println(pos);
                set.add(pos);
                if (pos >= n*n) {
                    return result;
                }
                for (int i = 1; i <= 6; i++) {
                    int next = pos + i;
                    if (map.containsKey(next)) {
                        queue.add(map.get(next));
                    } else {
                        queue.add(next);
                    }
                }
            }
            //System.out.println("****");
            result ++;

        }
        return -1;
    }
    
    private int [] getPos (int p)
    {
        p -=1;
        int row = n-1-(p/n);
        int col = p % n;
        if ((p/n) % 2 != 0) {
            col = n-1-col;
        }
        return new int[] {row, col};
    }
}