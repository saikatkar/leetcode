class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ']') {
                stack.push(ch);
            } else {
                String repeat = "";
                while (!stack.isEmpty() && stack.peek() != '[') {
                    repeat = stack.pop() + repeat;  
                }
                stack.pop();
                String num = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num = stack.pop() + num;
                }
                int n = Integer.parseInt(num);
                String str = "";
                while (n-- > 0) {
                    str = repeat + str;
                }
                if (!stack.isEmpty()) {
                   int k = 0;
                   //System.out.println(str); 
                   while (k < str.length()) {
                     stack.push(str.charAt(k)); 
                     k++;  
                   }
                } else {
                    result = result + str;
                } 
            }
        }
        System.out.println(result);
        String str = "";
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return result + str;
    }
}