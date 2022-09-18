/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node|null} root
 * @return {number[]}
 */
var postorder = function(root) {
    let result=[]
    return postOrdTraversal(root,result)
};

function postOrdTraversal(root,result){
    if(!root)
        return [];
    if(root.children.length){
        root.children.forEach(child=>{
         postOrdTraversal(child,result);
        })
    }
    if(root)
      result.push(root.val)
    return result;
}