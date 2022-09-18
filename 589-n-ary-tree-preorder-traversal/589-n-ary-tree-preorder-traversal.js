/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node|null} root
 * @return {number[]}
 */
var preorder = function(root) {
    let result=[];
    if(!root)
        return result;
    if(root)
      result.push(root.val)
    if(root.children.length){
        root.children.forEach(child=>{
         result.push(...preorder(child));
        })
    }
    return result;
};