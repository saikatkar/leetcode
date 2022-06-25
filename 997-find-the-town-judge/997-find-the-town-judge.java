class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] trusted = new int[n+1];
        boolean [] trusts = new boolean[n+1];
        for (int [] edge : trust) {
            trusted[edge[1]] ++;
            trusts[edge[0]] = true;
        }
        
        for (int i = 1; i <=n; i++) {
            if (trusted[i] == n-1 && !trusts[i]) {
                return i;
            }
        }
        return -1;
    }
}