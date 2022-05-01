class Solution {
    public int firstUniqChar(String s) {
        int [] alphabet = new int[26];
        char [] arr = s.toCharArray();
        for (char ch : arr) {
            alphabet[ch-97] ++;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (alphabet[arr[i] - 97] == 1) {
                return i;
            }
        }
        return -1;
    }
}