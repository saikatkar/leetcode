class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int [] arr = new int[26];
        char [] pArr = p.toCharArray();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < pArr.length; i++) {
            arr[pArr[i] - 'a']++;
        }
        int start = 0;
        char [] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            arr[sArr[i]-'a']--;
            if (i >= pArr.length) {
                arr[sArr[i-pArr.length]-'a']++;
                start++;
            }
            if (check(arr)) {
                result.add(start);
            }
        }
        return result;
    }
    
    private boolean check (int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}