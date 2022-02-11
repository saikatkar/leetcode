class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int [][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int x = king[0];
        int y = king[1];
        int [][] isQueen = new int[8][8];
        for (int i = 0; i < queens.length; i++) {
            isQueen[queens[i][0]][queens[i][1]] = 1;
        }
        List<List<Integer>> result = new LinkedList<>();
        //right
        int i = x;
        int j = y+1;
        while (j < 8) {
            if (isQueen[i][j] == 1) {
               List<Integer> list = new LinkedList<>();
               list.add(i);
               list.add(j);
               result.add(list);
               break; 
            } 
            j++; 
        }
        //left
        i = x;
        j = y-1;
        while (j >= 0) {
            if (isQueen[i][j] == 1) {
               List<Integer> list = new LinkedList<>();
               list.add(i);
               list.add(j);
               result.add(list); 
               break;
            }
            j--;
        }
        //bottom
        i = x+1;
        j = y;
        while (i < 8) {
            if (isQueen[i][j] == 1) {
               List<Integer> list = new LinkedList<>();
               list.add(i);
               list.add(j);
               result.add(list);
               break; 
            }
            i++;
        }
        //up
        i = x -1;
        j = y;
        while (i >= 0) {
           if (isQueen[i][j] == 1) {
               List<Integer> list = new LinkedList<>();
               list.add(i);
               list.add(j);
               result.add(list);
               break;
           }
           i--;  
        }
        //right bottom
        i = x+1;
        j = y+1;
        while (i < 8 && j < 8) {
           if (isQueen[i][j] == 1) {
               List<Integer> list = new LinkedList<>();
               list.add(i);
               list.add(j);
               result.add(list);
               break;
           }
           i++;
           j++;
        }
        // right up
        i = x-1;
        j = y+1;
        while (i >=0 && j < 8) {
            if (isQueen[i][j] == 1) {
               List<Integer> list = new LinkedList<>();
               list.add(i);
               list.add(j);
               result.add(list);
               break; 
            }
            i--;
            j++;
        }
        //left up
        i = x-1;
        j = y-1;
        while (i >= 0 && j >= 0) {
          if (isQueen[i][j] == 1) {
               List<Integer> list = new LinkedList<>();
               list.add(i);
               list.add(j);
               result.add(list);
               break;
          }
          i--;
          j--;
        }
        //left bottom
        i = x+1;
        j = y-1;
        while (i < 8 && j >= 0) {
           if (isQueen[i][j] == 1) {
               List<Integer> list = new LinkedList<>();
               list.add(i);
               list.add(j);
               result.add(list); 
               break;
            }
            i++;
            j--;
        }
        return result;
    }
}