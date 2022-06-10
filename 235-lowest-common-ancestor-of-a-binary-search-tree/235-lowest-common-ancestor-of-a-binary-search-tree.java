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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p|| root == q) return root;
        
        boolean pLeft = p.val < root.val;
        boolean qLeft = q.val < root.val;
        
        if (pLeft ^ qLeft) return root;
        
        if (pLeft && qLeft) return lowestCommonAncestor(root.left, p, q);
        
        return lowestCommonAncestor(root.right, p, q);
    }
}