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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<String> startValueDirection = findNode(root, startValue);
        List<String> destValueDirection = findNode(root, destValue);
        
        // System.out.println(startValueDirection);
        // System.out.println(destValueDirection);
        
        int index1 = 0, index2 = 0;
        
        while (index1 < startValueDirection.size() && index2 < destValueDirection.size()) {
            if (startValueDirection.get(index1).equals(destValueDirection.get(index2))) {
                index1++;
                index2++;
            } else {
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (index1 < startValueDirection.size()) {
            sb.append("U");
            index1++;
        }
        
        while (index2 < destValueDirection.size()) {
            sb.append(destValueDirection.get(index2));
            index2++;
        }
        
        return sb.toString();
    }
    
    private List<String> findNode(TreeNode root, int value) {
        List<String> list = new ArrayList<>();
        findNode(root, value, list);
        
        return list;
    }
    
    private boolean findNode(TreeNode root, int value, List<String> list) {
        if (root == null) return false;
        
        if (root.val == value) {
            return true;
        }
        
        if (findNode(root.left, value, list)) {
            list.add(0, "L");
            return true;
        }
        
        if (findNode(root.right, value, list)) {
            list.add(0, "R");
            return true;
        }
        
        return false;
    }
}