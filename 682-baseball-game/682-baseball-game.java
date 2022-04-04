class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String curr = ops[i];
            if (curr.equals("+")) {
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first + second);
            } else if (curr.equals("D")) {
                int n = stack.peek();
                stack.push(2*n);
            } else if (curr.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(curr));
            }
        }
        int result = 0;
        for (int s : stack) {
            result += s;
        }
        return result;
    }
}