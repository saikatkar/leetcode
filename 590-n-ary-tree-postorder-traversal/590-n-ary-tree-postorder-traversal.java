/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
       if (root == null) {
           return result;
       } 
       traverse(root);
       result.add(root.val); 
       return result;
    }
    
    private void traverse (Node root)
    {
        if (root == null) {
            return;
        }
        for (Node n : root.children) {
            traverse(n);
            result.add(n.val);
        }
    }
}