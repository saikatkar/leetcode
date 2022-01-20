class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int [] result = new int[mat.length*mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (map.containsKey(i+j)) {
                    map.get(i+j).add(mat[i][j]);
                } else {
                    List<Integer> list = new LinkedList<>();
                    list.add(mat[i][j]);
                    map.put(i+j, list);
                }
            }
        }
        int k = 0;
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i <= m+n-2; i++) {
            List<Integer> list = map.get(i);
            if (i % 2 == 0) {
                Collections.reverse(list);
            }
            for (Integer e : list) {
                result[k++] = e;
            }
        }
        return result;
    }
}