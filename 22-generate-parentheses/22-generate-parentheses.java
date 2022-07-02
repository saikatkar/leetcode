class Solution {
    List<String> resultList = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder result = new StringBuilder();
        generate(0, 0, 0, result, n);
        return resultList;
    }
    
    private void generate (int open, int close, int i, StringBuilder result, int n)     {
        if (i >= 2*n) {
            resultList.add(result.toString());
            return;
        }
        if (open < n) {
            result.append("(");
            generate(open + 1, close, i + 1, result, n);
            //open--;
            result.deleteCharAt(result.length()-1);
        }
        if (open > close) {
            result.append(")");
            generate(open, close + 1, i + 1, result, n);
            //close--;
            result.deleteCharAt(result.length()-1);
        }
        
    }
}