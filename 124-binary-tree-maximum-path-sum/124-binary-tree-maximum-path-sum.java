/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {};
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int mainAns = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathSumDP(root);
        
        return mainAns;
    }
    public int maxPathSumDP(TreeNode root) {
        if (root == null) return 0;
        
        int leftAns = maxPathSumDP(root.left);
        int rightAns = maxPathSumDP(root.right);
        
        int ans = root.val;
        
        mainAns = Math.max(mainAns, root.val + leftAns + rightAns);
        
        ans = Math.max(ans, root.val + leftAns);
        ans = Math.max(ans, root.val + rightAns);
        
        mainAns = Math.max(ans, mainAns);
        
        return ans;
    }
}