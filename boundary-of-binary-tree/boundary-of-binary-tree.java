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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        leftBoundaryOfBinaryTree(root.left, ans);
        leavesOfBinaryTree(root.left, ans);
        leavesOfBinaryTree(root.right, ans);
        rightBoundaryOfBinaryTree(root.right, ans);
        
        return ans;
    }
    
    private void leavesOfBinaryTree(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            ans.add(node.val);
            return;
        }
        leavesOfBinaryTree(node.left, ans);
        leavesOfBinaryTree(node.right, ans);
    }
    
    private void leftBoundaryOfBinaryTree(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        ans.add(node.val);
        if (node.left != null) {
            leftBoundaryOfBinaryTree(node.left, ans);
        } else {
            leftBoundaryOfBinaryTree(node.right, ans);
        }
    }
    
    private void rightBoundaryOfBinaryTree(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        if (node.right != null) {
            rightBoundaryOfBinaryTree(node.right, ans);
        } else {
            rightBoundaryOfBinaryTree(node.left, ans);
        }
        ans.add(node.val);
    }
}