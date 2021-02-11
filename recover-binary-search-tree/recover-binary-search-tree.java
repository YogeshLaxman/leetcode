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
    ArrayList<TreeNode> list;
    public void recoverTree(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        
        List<Integer> sortedList = new ArrayList();
        for (TreeNode node: list) {
            sortedList.add(node.val);
        }
        Collections.sort(sortedList);
        
        for(int i=0; i<list.size(); i++) {
            list.get(i).val = sortedList.get(i);
        }
        
    }
    
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }
}