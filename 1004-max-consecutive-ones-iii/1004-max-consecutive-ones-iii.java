class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int max = 0;
        int count = 0;
        int start = 0;
        int end = 0;
        while (end < nums.length) {
           if (nums[end] == 0) {
                zeroCount ++;
           }
           while (zeroCount > k) {
              if (nums[start] == 0) {
                zeroCount--; 
              }
              start ++; 
           }
           max = Math.max(max, end-start+1); 
           end++; 
        }
        return max;
    }
}