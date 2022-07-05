class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        generate (1, n, k, new ArrayList<>());
        
        return resultList;
    }
    
    private void generate (int i, int n, int k, List<Integer> result)
    {
        if (result.size() == k) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        for (int j = i; j <=n; j++) {
            result.add(j);
            generate(j+1, n, k, result);
            result.remove(result.size()-1);
        }
        //result.remove(result.size()-1);
    }  
}