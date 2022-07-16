class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int [] queens = new int[n];
        nQueens(n, 0, queens);
        return count;
    }
    
    private void nQueens (int n, int index, int [] queens)
    {
        if (index == n) {
            count ++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(index, queens, i)) {
                queens[index] =i;
                nQueens(n, index+1, queens);
            }
        }
    }
    
    private boolean isValid (int index, int [] queens, int pos)
    {
        for (int i = 0; i < index; i++) {
            if (queens[i] == pos) {
                return false;
            }
            if (Math.abs(queens[i] - pos) == Math.abs (i - index)) {
                return false;
            }
        }
        return true;
    }
}