class Solution {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length-1);
    }
    
    private int find (int[] nums, int low, int high) 
    {
        while (low <= high) {
            int mid = low + (high-low)/2;
            //System.out.println(mid);
            if (mid>0 && nums[mid] < nums[mid-1]){
                return nums[mid];
            } else if (nums[mid] > nums[high]) {
                low = mid+1;
            } else {
                high = mid-1;
            } 
        }
        return nums[0];
    }
}