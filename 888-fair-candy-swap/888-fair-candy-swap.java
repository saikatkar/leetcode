class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        int bobSum = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int a : aliceSizes) {
            aliceSum += a;
        }
        for (int b : bobSizes) {
            bobSum += b;
            set.add(b);

        }
        
        int d = (bobSum - aliceSum)/2;
        
        for (int x : aliceSizes) {
            if (set.contains(x+d)) {
                return new int[]{x, x+d};
            }
        }
        return new int[]{};
    }
}