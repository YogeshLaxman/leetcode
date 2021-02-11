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
class CBTInserter {

    TreeNode root;
    Queue<TreeNode> queue;
    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.add(root);
        
        while (true) {
            TreeNode node = queue.peek();
            if (node.left == null || node.right == null) {
                if (node.left != null) queue.add(node.left);
                break;
            }
            queue.poll();
            queue.add(node.left);
            queue.add(node.right);
        }
    }
    
    public int insert(int v) {
        TreeNode node = queue.peek();
        if (node.left == null) {
            TreeNode newNode = new TreeNode(v);
            node.left = newNode;
            queue.add(newNode);
            return node.val;
        }
        if (node.right == null) {
            TreeNode newNode = new TreeNode(v);
            node.right = newNode;
            queue.add(newNode);
            return node.val;
        }
        queue.poll();
        return insert(v);
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */