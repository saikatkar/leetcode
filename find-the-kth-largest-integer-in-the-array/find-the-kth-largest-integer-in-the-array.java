class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Queue<String> pq = new PriorityQueue<>(
            (s1, s2) -> {
                int n1 = s1.length();
                int n2 = s2.length();
                if (n1 == n2) {
                    return s1.compareTo(s2);
                }
                return n1 - n2;
        });
        
        for (String s : nums) {
            pq.add(s);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}