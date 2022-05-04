class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int result = Integer.MIN_VALUE;
        while (i < j) {
            result = Math.max(result, nums[i] + nums[j]);
            i++;j--;
        }
        return result;
    }
}