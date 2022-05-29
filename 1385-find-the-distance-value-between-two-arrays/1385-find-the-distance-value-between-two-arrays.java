class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        Arrays.sort(arr2);
        for (int a : arr1) {
            if (search(arr2, a-d, a+d)) {
                count++;
            }
        }
        return arr1.length-count;
    }
    
    private boolean search (int [] arr, int r1, int r2) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (arr[mid] >= r1 && arr[mid] <= r2) {
                return true;
            }
            if (arr[mid] < r1) {
                start = mid+1;
            } else if (arr[mid] > r2) {
                end = mid-1;
            }
        }
        return false;
    } 
}