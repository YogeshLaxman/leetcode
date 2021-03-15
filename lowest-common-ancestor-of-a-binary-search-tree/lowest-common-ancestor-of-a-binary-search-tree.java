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
        TreeNode l = p, h = q;
        
        if (p.val > q.val) {
            l = q; h = p;
        }
        
        return lowestCommonAncestorDP(root, l, h);
    }
    
    private TreeNode lowestCommonAncestorDP(TreeNode root, TreeNode l, TreeNode h) {
        if (root.val >= l.val && root.val <= h.val) {
            return root;
        } else if (root.val > h.val) {
            return lowestCommonAncestorDP(root.left, l, h);
        } else {
            return lowestCommonAncestorDP(root.right, l, h);
        }
    }
}