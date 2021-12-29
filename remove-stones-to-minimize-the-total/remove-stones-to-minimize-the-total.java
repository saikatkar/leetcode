class Solution {
    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int p : piles) {
            pq.add(p);
        }
        int result = 0;
        while (k > 0) {
            int p = pq.poll();
            int p2 = p/2;
            pq.add(p-p2);
            k--;
        }
        
        for (int p : pq) {
            result += p;
        }
        return result;
    }
}