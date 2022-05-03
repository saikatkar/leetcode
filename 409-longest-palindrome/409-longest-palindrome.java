class Solution {
    public int longestPalindrome(String s) {
        int [] countArr = new int[128];
        for (char ch : s.toCharArray()) {
            countArr[ch]++;
        }
        int countOdd = 0;
        int result = 0;
        for (int c : countArr) {
            result += c/2 * 2;
            if (result % 2 == 0 && c%2 == 1) {
                result ++;
            }
        }
        return result;
    }
}