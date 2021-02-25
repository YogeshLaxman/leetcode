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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode next = stack.pop();
            answer.add(next.val);
            
            TreeNode right = next.right;
            
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return answer;
    }
}