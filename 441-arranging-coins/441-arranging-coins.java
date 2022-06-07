class Solution {
    public int arrangeCoins(int n) {
        long low = 1;
        long high = n;
        while (low <= high) {
            long mid = low + (high - low)/2;
            long totalSum = (mid * (mid+1))/2;
            if (totalSum == n) {
                return (int)mid;
            } else if (totalSum > n ) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return (int)high;
    }
}