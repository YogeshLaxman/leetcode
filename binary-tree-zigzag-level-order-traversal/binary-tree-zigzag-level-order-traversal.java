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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(root);
        
        while( s1.isEmpty()==false || s2.isEmpty()==false ){
            List<Integer> currLevel = new ArrayList<>();
            while(s1.isEmpty() == false){
                int s1Size = s1.size();
               
                
                for(int i = 0 ; i< s1Size ; i++){
                    TreeNode currNode = s1.pop();
                    currLevel.add(currNode.val);
                    if(currNode.left !=null) s2.push(currNode.left);
                    if(currNode.right !=null) s2.push(currNode.right);
                }
                
            }
            if(currLevel.size() > 0) result.add(currLevel);
            currLevel = new ArrayList<>();
             while(s2.isEmpty() == false){
                int s2Size = s2.size();                 
                 for(int i = 0 ; i< s2Size ; i++){
                    TreeNode currNode = s2.pop();
                    currLevel.add(currNode.val);
                    if(currNode.right !=null) s1.push(currNode.right);
                    if(currNode.left !=null) s1.push(currNode.left);
                 }
                
            }
            
            if(currLevel.size() > 0) result.add(currLevel);
        }
        
        return result;
    }
}
