class Solution {
    public int numberOfBeams(String[] bank) {
        int [] arr = new int[bank.length];
        int k = 0;
        for (int i = 0; i < bank.length; i++) {
            int count = 0;
            for (int j = 0; j < bank[0].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    count++;
                }
            }
            if (count > 0) {
              arr[k++] = count;  
            }
        }
        
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            result += arr[i-1] * arr[i];
        }
        return result;
    }
}