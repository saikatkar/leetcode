class Solution {
    public String tictactoe(int[][] moves) {
        int m = moves.length;
        int n = moves[0].length;
        int diagon = 0;
        int antidiagon = 0;
        int totalRow = 0;
        int totalCol = 0;
        
        int [] row = new int[3];
        int [] col = new int[3];
        
        for (int i = 0; i < moves.length; i++) {
            int [] move = moves[i];
            int r = move[0];
            int c = move[1];
            row[r] += i%2==0? 1:-1;
            col[c] += i%2==0? 1:-1;
            
            if (r == c) {
                diagon += i%2==0? 1:-1;
            }
            if (c+r == 2) {
                antidiagon += i%2==0? 1:-1;
            }
            for (int c1 : col) {
                if (c1 == 3) {
                    return "A";
                }
                if ( c1 == -3) {
                    return "B";
                }
            }
            for (int r1 : row) {
                if (r1 == 3) {
                    return "A";
                }
                if ( r1 == -3) {
                    return "B";
                }
            }
            if (diagon == 3) {
                return "A";
            }
            if (diagon == -3) {
                return "B";
            }
            if (antidiagon == 3) {
                return "A";
            }
            if (antidiagon == -3) {
                return "B";
            }
        }
        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";  
    }
}