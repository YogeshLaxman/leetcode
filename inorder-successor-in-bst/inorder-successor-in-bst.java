/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode ans;
    public boolean inorderSuccessor(TreeNode root, TreeNode p, TreeNode parent) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            if (root.right != null) {
                ans = root.right;
                while(ans.left != null) {
                    ans = ans.left;
                }
            } else {
                ans = parent;
            }
            return true;
        }
        boolean pFound = inorderSuccessor(root.left, p, root);
        if (!pFound) {
            pFound = inorderSuccessor(root.right, p, parent);
        } 
        return pFound;
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorderSuccessor(root, p, null);
        return ans;
    }
}