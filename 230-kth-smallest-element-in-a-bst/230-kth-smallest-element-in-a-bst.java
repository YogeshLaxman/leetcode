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
    int ans = 0;
    int index = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }
    
    private boolean inOrder(TreeNode node, int k) {
        if (node == null) return false;
        
        if (inOrder(node.left, k)) return true;
        index++;
        if (index == k) {
            ans = node.val;
            return true;
        }
        if (inOrder(node.right, k)) {
            return true;
        }
        
        return false;
    }
}