class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int [] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1 ;i <= n; i++) {
            int p = 9;
            int p1 = p;
            for (int j = 0; j < i-1; j++) {
                p1 = p1*(p-j);
            }
            dp[i] = dp[i-1] + p1;
        }
        return dp[n];
    }
}