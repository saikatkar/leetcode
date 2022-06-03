class Solution {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length-1);
    }
    
     private int search(int[] arr, int start, int end) {
        while (start < end) {
            int mid = start + (end -start)/2;
            if (arr[mid+1] > arr[mid]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start; 
    }
}