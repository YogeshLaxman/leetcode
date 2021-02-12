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
    private int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + maxHeight(root.left);
    }
    
    private boolean nodeAbsent(TreeNode root, int h) {
        if (h == 0) {
            return root == null;
        }
        if (h == 1) {
            return root.right == null;
        }
        root = root.right;
        h--;
        
        while (h-- > 0) {
            root = root.left;
        }
        
        return root == null;
    }
    
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = maxHeight(root.left);
        int power2_h = ((int) Math.pow(2, h));
        int count = power2_h - 1;
        
        while (h >= 0) {    
            if (!nodeAbsent(root, h)) {
                // System.out.println(root.val + ":" + power2_h);
                count += Math.max(1, power2_h/2);
                root = root.right;
            } else {
                root = root.left;
            }
            power2_h = power2_h/2;    
            h--;
        }
        return count;
    }
}