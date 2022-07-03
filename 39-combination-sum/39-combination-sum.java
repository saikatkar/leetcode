class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        generate(candidates, 0, candidates.length, new ArrayList<>(), target, 0);
        return resultList;
    }
    
    private void generate (int [] candidates, int i, int n,
                           List<Integer> result, int target, int sum)
    {
        if (sum == target) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int j = i; j < n ;j++) {
            sum += candidates[j];
            result.add(candidates[j]);
            generate(candidates, j, n, result, target, sum);
            sum -= candidates[j];
            result.remove(result.size()-1);
        }
    }
}