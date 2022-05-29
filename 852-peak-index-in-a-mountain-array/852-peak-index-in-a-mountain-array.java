class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return search(arr, 0, arr.length-1);
    }
    
    private int search(int[] arr, int start, int end) {
        while (start <= end) {
            int mid = start + (end -start)/2;
            if (mid == 0) {
                start = mid+1;
                continue;
            }
            if (mid == arr.length-1) {
                end = mid-1;
                continue;
            }
            if (arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) {
                return mid;
            }
            if (arr[mid] > arr[mid+1] && arr[mid] < arr[mid-1]) {
                end = mid-1;
            } else if (arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]) {
                start = mid+1;
            }
        }
        return -1;
    }
}