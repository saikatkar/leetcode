class Solution {
    public String removeDuplicateLetters(String s) {
        
        int [] lastSeen = new int[26];
        boolean [] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();
        char [] sArr = s.toCharArray();
        
        for (int i = 0; i < sArr.length; i++) {
            lastSeen[sArr[i] - 'a'] = i;
        }
        
        for (int i = 0; i < sArr.length; i++) {
            char curr = sArr[i];
            if (seen [curr-'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > curr &&
                   i < lastSeen[stack.peek() - 'a']) {
                char ch = stack.pop();
                seen[ch - 'a'] = false;
            }
            stack.push(curr);
            seen[curr - 'a'] = true;
        }
        String result = "";
        //System.out.println(stack);
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}