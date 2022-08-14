class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int [] dp = new int[nums.length+1];
        if (nums.length < 3) {
            return 0;
        }
        int result = 0;
        dp[0] = 0;
        dp[1] = 0;
        //dp[2] = 1;
        for (int i = 1; i < nums.length-1; i ++) {
           if (nums[i] - nums[i-1] == nums[i+1] - nums[i]) {
               dp[i+1] = dp[i] + 1;
               result += dp[i+1];
           }
        }
        return result;
    }
}