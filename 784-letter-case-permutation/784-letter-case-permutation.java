class Solution {
    Set<String> result = new HashSet<>();
    public List<String> letterCasePermutation(String s) {
        generate(s.toCharArray(), 0);
        List<String> resultList = new ArrayList<>();
        resultList.addAll(result);
        return resultList;
    }
    private void generate (char [] sArr, int j)
    {
        result.add(new String(sArr));
        for (int i = j; i < sArr.length; i++) {
            if (sArr[i] >= 48 && sArr[i] <= 57) {
                continue;
            }
            char ch = sArr[i];
            if (ch >= 65 && ch <= 90) {
                sArr[i] = (char)(ch + 32);
                generate(sArr, i+1);
                sArr[i] = ch;
            } else {
                sArr[i] = (char)(ch - 32);
                generate(sArr, i+1);
                sArr[i] = ch;
            }
        }
    }
}