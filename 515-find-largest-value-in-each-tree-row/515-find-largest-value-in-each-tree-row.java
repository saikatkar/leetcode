/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        // result.add(root.val);
        queue.add(root);
        while (!queue.isEmpty()) {
            int i = queue.size();
            max = Integer.MIN_VALUE;
            while (i > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                max = Math.max(node.val, max);
                i--;
            }
            result.add(max);
        }
        return result;
    }
}