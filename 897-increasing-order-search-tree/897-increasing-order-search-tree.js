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
 * @return {TreeNode}
 */
var increasingBST = function(root) {
    let arr= InorderTraversal(root)
    let rootNode=new TreeNode(arr[0],null,null)
    root=rootNode;
    for(let i=1;i<arr.length;i++){
            rootNode.left=null;
            let r=new TreeNode(arr[i],null,null);
            rootNode.right=r;
            rootNode=rootNode.right
    }
   return root;
};

function InorderTraversal(root){
    let arr=[];
    if(root.left){
        arr.push(...InorderTraversal(root.left))
    }
    arr.push(root.val)
    if(root.right){
        arr.push(...InorderTraversal(root.right))
    }
    
    return arr;
}