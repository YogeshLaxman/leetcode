/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // specify range for every node
        return isBST(root,null,null);
    }
    
    public boolean isBST( TreeNode currNode, Integer min, Integer max){
        
        if(currNode == null){
            return true;
        }
        else if ( (min!=null && currNode.val <= min)  ||
                  (max!=null && currNode.val >= max) 
                )   {
            return false;
        }
        else
            return isBST(currNode.left,min,currNode.val) &&
                   isBST(currNode.right,currNode.val,max);
    }
}
