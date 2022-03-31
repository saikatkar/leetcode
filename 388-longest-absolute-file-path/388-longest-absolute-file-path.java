class Solution {
    public int lengthLongestPath(String input) {
        Stack<Node> stack = new Stack<>();
        String [] lines = input.split("\n");
        int maxSize = 0;
        int length = 0;
         for (String line : lines) {
            int depth = line.lastIndexOf("\t") + 1;
            while (!stack.isEmpty() && stack.peek().depth >= depth) {
                Node popped = stack.pop();
                length -= popped.name.length()+1;
            }
            if (line.indexOf(".") != -1) {
                maxSize = Math.max(maxSize, length + line.length() - depth);
            } else {
                Node node = new Node(line.substring(depth, line.length()), depth);
                length += node.name.length()+1;
                stack.push(node);
            }
         }

        return maxSize;
    }
}

class Node
{
    String name;
    int depth;
    
    Node (String name, int depth)
    {
        this.name = name;
        this.depth = depth;
    }
}