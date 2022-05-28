class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int indx = binarySearch(nums, target, 0, nums.length-1);
        if (indx == -1) {
            return result;
        }
        result.add(indx);
        int nxtIndx = indx+1;
        System.out.println(nxtIndx);
        while (nxtIndx < nums.length && nums[nxtIndx] == target) {
            result.add(nxtIndx++);
        }
        int prevIndx = indx-1;
        System.out.println(prevIndx);
        while (prevIndx >= 0 && nums[prevIndx] == target) {
            result.add(prevIndx--);
        }
        Collections.sort(result);
        return result;
    }
    private int binarySearch (int[] nums, int target, int low, int high)
    {
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                return mid;
            } 
            else if (nums[mid] > target) {
                high = mid-1;
            } 
            else {
                low = mid+1;
            }
        }
        return -1;
    }
}