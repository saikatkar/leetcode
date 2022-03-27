class Solution {
    public String simplifyPath(String path) {
      String [] components = path.split("/");
      Stack<String> stack = new Stack<>();
      for (String component : components) {
          if (component.equals("") || component.equals(".")) {
              continue;
          } else if (component.equals("..")) {
              if (!stack.isEmpty()) {
                stack.pop();    
              }
          } else {
              stack.push(component);
          }    
      }
      //System.out.println(stack);  
      if (stack.isEmpty()) {
        return "/";    
      }  
      String ans = "";
      for (String s : stack) {
          ans += "/" + s;
      }  
      return ans;
    }
}