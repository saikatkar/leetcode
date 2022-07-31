class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char [] textArr1 = text1.toCharArray();
        char [] textArr2 = text2.toCharArray();
        
        int [][] lcs = new int[textArr1.length+1][textArr2.length+1];
        
        for (int i = 1; i < lcs.length; i++) {
            for (int j = 1; j < lcs[0].length; j++) {
                if (textArr1[i-1] == textArr2[j-1]) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        return lcs[lcs.length-1][lcs[0].length-1];
    }
}