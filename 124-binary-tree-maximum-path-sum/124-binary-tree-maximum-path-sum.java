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
    int max;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        pathSum(root);
        
        return max;
    }
    
    private int pathSum(TreeNode root) {
        if (root == null) return 0;
        
        int left = pathSum(root.left);
        int right = pathSum(root.right);
        
        max = Math.max(max, left + root.val);
        max = Math.max(max, right + root.val);
        max = Math.max(max, left + right + root.val);
        max = Math.max(max, root.val);
        
        return Math.max(root.val,  Math.max(left, right) + root.val);
    }
}