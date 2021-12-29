class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int result = 1;
        Set<Character> set = new HashSet<>();
        int wStart = 0;
        int wEnd = 0;
        while (wEnd < s.length()) {
            if (!set.contains(s.charAt(wEnd))) {
                set.add(s.charAt(wEnd));
                result = Math.max(result, wEnd-wStart+1);
            } else {
                while (s.charAt(wStart) != s.charAt(wEnd)) {
                    set.remove(s.charAt(wStart));
                    wStart++;                  
                }
                set.add(s.charAt(wStart));
                wStart++;
            }
            wEnd ++;
        }
        return result;
    }
}