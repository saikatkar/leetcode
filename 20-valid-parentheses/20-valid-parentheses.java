class Solution {
    public boolean isValid(String s) {
        char arr[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (ch == ')' && pop != '(') {
                    return false;
                }
                if (ch == '}' && pop != '{') {
                    return false;
                }
                if (ch == ']' && pop != '[') {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}