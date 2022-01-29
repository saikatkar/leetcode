class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, LinkedList<Integer>> listMap = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (listMap.containsKey(i-j)) {
                    listMap.get(i-j).add(mat[i][j]);
                } else {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(mat[i][j]);
                    listMap.put((i-j), list);
                }
            }
        }
        //System.out.println(listMap);
        
        for (Integer key : listMap.keySet()) {
            Collections.sort(listMap.get(key));
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i-j;
                LinkedList<Integer> list = listMap.get(index);
                mat[i][j] = list.removeFirst();
            }
        }
        return mat;
    }
}