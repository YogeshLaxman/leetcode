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
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int i ,int j, int m, int n) {
        // System.out.println(i + ":" + j + ":" + m + ":" + n);
        if (i > j || m > n) return null;
        
        if (i == j && m == n && inorder[m] == preorder[i]) {
            return new TreeNode(inorder[m]);
        }
        
        int x = -1;
        int num = 0;
        for (int k=m; k<=n; k++) {
            if (inorder[k] == preorder[i]) {
                x = k;
                break;
            }
            num++;
        }
        
        // System.out.println(num);
        TreeNode node = new TreeNode(inorder[x]);
        
        node.left = buildTree(preorder, inorder, i+1, i+num, m, x-1);
        node.right = buildTree(preorder, inorder, i+num+1, j, x+1, n);
        
        return node;
    }
    
    // L - D - R
    // D - L - R
}