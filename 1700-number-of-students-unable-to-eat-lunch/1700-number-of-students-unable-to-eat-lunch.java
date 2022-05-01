class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = sandwiches.length-1; i>=0; i--) {
            stack.push(sandwiches[i]);
        }
        
        for (int s : students) {
            queue.add(s);
        }
        int count = 0;
        while (!stack.isEmpty()) {
            if (queue.peek() == stack.peek()) {
                queue.poll();
                stack.pop();
                count = 0;
            } else {
                queue.add(queue.poll());
                count ++;
                if (count == stack.size()) {
                    break;
                }
            }
        }
        return count;
    }
}