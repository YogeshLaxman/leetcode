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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, map);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int i ,int j, int m, int n, Map<Integer, Integer> inOrderMap) {
        
        if (i > j || m > n) return null;
        
        if (i == j && m == n && inorder[m] == preorder[i]) {
            return new TreeNode(inorder[m]);
        }
        
        int x = inOrderMap.get(preorder[i]);
        int num = x-m;       
        TreeNode node = new TreeNode(inorder[x]);
        // System.out.println(preorder[i] + ":" + x + ":" + num);
        node.left = buildTree(preorder, inorder, i+1, i+num, m, x-1, inOrderMap);
        node.right = buildTree(preorder, inorder, i+num+1, j, x+1, n, inOrderMap);
        
        return node;
    }
    
    // L - D - R
    // D - L - R
}