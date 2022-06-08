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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long minValue, long maxValue) {
        if (node == null) return true;
        
        boolean nodeValid = node.val > minValue && node.val < maxValue;
        boolean leftValid = isValidBST(node.left, minValue, node.val);
        boolean rightValid = isValidBST(node.right, node.val, maxValue);
        
        return nodeValid && leftValid && rightValid;
        
    }
}