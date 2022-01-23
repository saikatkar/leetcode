class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        int col = image[0].length;
        for (int i = 0 ; i < image.length; i++) {
            int [] arr = image[i];
            for (int c = 0; c < (col+1)/2; c++) {
                int temp = arr[col-c-1]^1;
                arr[col-c-1] = arr[c]^1;
                arr[c] = temp;
            }   
        }
        return image;
    }
}