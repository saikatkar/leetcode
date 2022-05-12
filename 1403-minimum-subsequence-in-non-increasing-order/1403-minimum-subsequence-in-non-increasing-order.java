class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        sum = sum/2;
        int currSum = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            if (currSum <= sum) {
                list.add(nums[i]);
            }
            currSum += nums[i];
        }
        return list;
    }
}