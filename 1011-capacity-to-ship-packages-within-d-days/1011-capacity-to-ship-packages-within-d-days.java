class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int w : weights) {
            high += w;
            low = Math.max(low, w);
        }
        
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (possibleToShip(weights, mid,days)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return high+1;
    }
    
    private boolean possibleToShip (int [] weights, int capacity, int days)
    {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < weights.length; i++) {
             if (weights[i] > capacity) {
                 return false;
             }
            sum += weights[i];
            if (sum > capacity) {
                count++;
                sum = weights[i];
            }
        }
        count++;
        return count <= days;
    }
}