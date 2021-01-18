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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        
        int leftValue1 = root1.left == null ? -1 : root1.left.val;
        int rightValue1 = root1.right == null ? -1 : root1.right.val;
        
        int leftValue2 = root2.left == null ? -1 : root2.left.val;
        int rightValue2 = root2.right == null ? -1 : root2.right.val;
        
        if (leftValue1 == leftValue2 && rightValue1 == rightValue2) {
            return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        } else if (leftValue1 == rightValue2 && rightValue1 == leftValue2) {
            return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        } else {
            return false;
        }
    }
}
