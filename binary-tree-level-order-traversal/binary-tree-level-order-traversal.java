class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int qSize = q.size(); // necessary not just fancy
            List<Integer> currLevel = new ArrayList<>();
           
            for( int i = 0 ; i<qSize ; i++){
                
                TreeNode currNode = q.poll();
                currLevel.add(currNode.val);
                if(currNode.left != null ) q.add(currNode.left);
                if(currNode.right != null ) q.add(currNode.right);
            }
            result.add(currLevel);  
        }
        
        return result;
    }
}
