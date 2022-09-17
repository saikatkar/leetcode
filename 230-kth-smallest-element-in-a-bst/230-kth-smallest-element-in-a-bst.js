/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(root, k) {
   let array= inOrder(root)
   return array[k-1]
};

function inOrder(root){
    let arr=[];
    if(root.left){
        arr.push(...inOrder(root.left))
    }
    arr.push(root.val);
    if(root.right){
        arr.push(...inOrder(root.right))
    }
    return arr;
}