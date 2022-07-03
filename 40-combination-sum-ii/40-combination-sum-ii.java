class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        generate(0, candidates.length, 0, candidates, target, new ArrayList<>());
        return resultList;
    }
    
    private void generate (int j, int n, int sum, int [] candidates,
                           int target, List<Integer> result)
    {
       
        if (sum == target) {
            resultList.add(new ArrayList<>(result));
            return;
        }        
        if (sum  > target) {
            return;
        }
        
        for (int i = j; i < n; i++) {
            if (candidates[i] <= target) {
                if (i > j && candidates[i] == candidates[i-1]) {
                    continue;
                } 
                sum += candidates[i];
                result.add(candidates[i]);
                generate(i+1, n, sum, candidates, target, result);
                sum -= candidates[i];
                result.remove(result.size()-1);       
            }
        }
    }
}