class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int j = 0;
        int i = 0;
        while (list.size () > 1) {
            j++;
            if (j == k) {
                i = i % list.size();
                list.remove(i);
                j = 0;
            } else {
                i++;
            }
        }
        return list.get(0);
    }
}