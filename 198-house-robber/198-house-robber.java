class Solution {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        if (nums.length< 2){
            return nums[0];
        }
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length];
    }
}