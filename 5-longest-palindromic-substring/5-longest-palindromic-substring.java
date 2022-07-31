class Solution {
    public String longestPalindrome(String s) {
        boolean [][] pal = new boolean[s.length()][s.length()];
        int maxLen = 1;
        String result = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    pal[i][j] = true;
                }
                if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    pal[i][j] = true;
                    maxLen = 2;
                    result = s.substring(i, j+1);
                }
            }
        }
        //System.out.println(Arrays.deepToString(pal));
        int k = 2;
        while (k  < s.length()) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + k;
                //System.out.println(i + " : " + j);
                if (j < s.length()) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (pal[i+1][j-1]) {
                            pal[i][j] = true;
                            maxLen = j-i+1;
                            result = s.substring(i, j+1);
                        }
                    }
                }
            }
            k++;
        }
        return result;
    }
}