class Solution {
    public String removeKdigits(String num, int k) {
      Stack<Character> stack = new Stack<>();
      char[] numArr = num.toCharArray();
      for (int i = 0; i < numArr.length; i++) {
          while (!stack.isEmpty() && stack.peek() > numArr[i] && k > 0) {
              stack.pop();
              k--;
          }
          stack.push(numArr[i]);
      }
      
      while (k > 0 && !stack.isEmpty()) {
          stack.pop();
          k--;
      }
      Stack<Character> tempStack = new Stack<>();
      while (!stack.isEmpty()) {
          tempStack.push(stack.pop());
      }
      while(!tempStack.isEmpty() && tempStack.peek() == '0') {
          tempStack.pop();
      }
      char [] result = new char[tempStack.size()];
      int i = 0;  
      while (!tempStack.isEmpty()) {
          result[i++] = tempStack.pop();
      }
      return result.length == 0 ? "0" : String.valueOf(result); 
    }
}