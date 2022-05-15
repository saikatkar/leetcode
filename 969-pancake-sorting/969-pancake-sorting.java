class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int val = arr.length; val > 0; val--) {
            int i = find(arr, val);
            if (i == val-1) {
                continue;
            }
            if (i != 0) {
                result.add(i+1);
                flip(arr, 0, i);
            }
            result.add(val);
            flip(arr, 0, val-1);
        }
        return result;
    }
    
    private int find (int[] arr, int val) {
        int i =0;
        for (; i < arr.length; i++) {
            if (arr[i] == val) {
                break;
            }
        }
        return i;
    }
    
    private void flip (int [] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}