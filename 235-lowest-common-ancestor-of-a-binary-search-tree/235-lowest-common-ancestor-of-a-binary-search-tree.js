/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    if(root && (root.val<q.val && p.val<root.val)||(root.val<p.val && q.val<root.val)){
        return root;
    }
    else if(root && root.val==q.val || p.val==root.val){
        return root;
    }
    else if(root && root.val>p.val && root.val>q.val){
        if(root.left){
       return lowestCommonAncestor(root.left,p,q);
        }
    }
    else if(root && root.val<p.val && root.val<q.val){
        if(root.right){
            console.log(root.right.val)
           return lowestCommonAncestor(root.right,p,q) ;
        }
    }
    
    
};