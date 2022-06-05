class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int [] first = new int[intervals.length];
        int [] result = new int[intervals.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            first[i] = intervals[i][0];
            map.put(intervals[i][0], i);
        }
        Arrays.sort(first);
        for (int i = 0; i <intervals.length; i++) {
            int idx = search(first, intervals[i][1]);
            if (idx == first.length) {
                result[i] = -1;    
            } else {
                result[i] = map.get(first[idx]);
            }
        }
        return result;
        
    }
    
    private int search(int [] first, int target) {
        int low = 0;
        int high = first.length;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (first[mid] == target) {
                return mid;
            }else if (first[mid] < target) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}