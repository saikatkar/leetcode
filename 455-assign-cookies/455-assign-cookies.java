class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int satisfied = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,j = 0;
        for (i = g.length -1, j = s.length-1; i>=0 && j>=0; ) {
            if (g[i] <= s[j]) {
                i--;
                j--;
                satisfied++;
            } else {
                i--;
            }
        }
        return satisfied;
    }
}