class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int [] result = new int[nums.length];
        
        for (int i = nums.length-1; i >= 0; i--) {
            int curr = nums[i];
            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }
            stack.push(curr);
        }
        for (int i = nums.length-1; i >= 0; i--) {
            int curr = nums[i];
            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(curr);
        }
        return result;
    }
}