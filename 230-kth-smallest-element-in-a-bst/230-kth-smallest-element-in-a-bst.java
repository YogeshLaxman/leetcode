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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedList = new ArrayList<>();
        inOrder(root, sortedList);
        return sortedList.get(k-1);
    }
    
    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}