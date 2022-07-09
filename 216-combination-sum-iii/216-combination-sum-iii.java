class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        generate(k, n, 1, new ArrayList<>());
        return resultList;
    }
    
    private void generate (int k, int n, int i, List<Integer> result)
    {
        if (k == 0 && n == 0) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        if (k <= 0 || n <= 0) {
            return;
        }
        for (int j = i; j <= 9; j++) {
            if (j > n) {
                continue;
            }
            result.add(j);
            generate(k-1, n-j, j+1, result);
            result.remove(result.size() - 1);
        }
    }
}