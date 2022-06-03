class Solution {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length-1);
    }
    private int find (int[] nums, int low, int high) 
    {
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] > nums[high]) {
                low = mid+1;
            } else if (nums[mid] < nums[high]){
                high = mid;
            } else {
                high--;
            }
        }
        return nums[low];
    }
}