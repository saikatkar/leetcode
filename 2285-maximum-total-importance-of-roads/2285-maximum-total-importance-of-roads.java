class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int [][] count = new int[n][2];
        for (int [] road : roads) {
            count[road[0]][0] ++;
            count[road[1]][0] ++;
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int [] c : count) {
            pq.add(c);
        }
        while (!pq.isEmpty()) {
            int [] c = pq.poll();
            c[1] = n--;
        }
        long importance = 0;
        for (int[] road : roads) {
            importance += count[road[0]][1] + count[road[1]][1];
        }
        return importance;
    }
}