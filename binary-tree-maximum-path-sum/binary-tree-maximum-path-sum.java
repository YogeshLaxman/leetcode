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
    
    int maxPathSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxPathSum;
    }
    
    public int maxGain(TreeNode currNode){
        if(currNode == null)
            return 0;
        
        int leftGain = Math.max(maxGain(currNode.left),0);
        int rightGain = Math.max(maxGain(currNode.right),0);
        
        int newPathSum = currNode.val + leftGain + rightGain;
        maxPathSum = Math.max(newPathSum, maxPathSum);
        
        return Math.max(leftGain,rightGain) + currNode.val;
    }
}
