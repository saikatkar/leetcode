class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        generate(candidates, 0, candidates.length, new ArrayList<>(), target, 0);
        return resultList;
    }
    
    private void generate (int [] candidates, int i, int n,
                           List<Integer> result, int target, int sum)
    {
        if (i >= n) {
            if (sum == target) {
              resultList.add(new ArrayList<>(result));  
            }
            return;
        }
        if (sum < target) {
            sum += candidates[i];
            result.add(candidates[i]);
            generate(candidates, i, n, result, target, sum);
            sum -= candidates[i];
            result.remove(result.size() - 1);
        }
        generate(candidates, i+1, n, result, target, sum);
    }
}