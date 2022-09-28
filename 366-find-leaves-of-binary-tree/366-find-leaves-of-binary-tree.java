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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        updatLeaves(root, ans);
        
        return ans;
    }
    
    int updatLeaves(TreeNode root, List<List<Integer>> ans) {
        if (root == null) return -1;
        
        int left = updatLeaves(root.left, ans);
        int right = updatLeaves(root.right, ans);
        
        int current = Math.max(left, right);
        
        current += 1;
        
        while (ans.size() <= current) {
            ans.add(new ArrayList<>());
        }
        
        ans.get(current).add(root.val);
        
        return current;
    }
}