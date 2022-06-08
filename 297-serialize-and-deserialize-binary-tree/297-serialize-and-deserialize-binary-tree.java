/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node == null) {
                list.add(null);
            } else {
                list.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        
        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        
        String[] split = data.split(",");
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        
        queue.add(root);
        int index = 1;
        while(index < split.length) {
            TreeNode node = queue.poll();
            
            if (!split[index].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(split[index]));
                node.left = leftNode;
                queue.add(leftNode);
            }
            
            index++;
            if (!split[index].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(split[index]));
                node.right = rightNode;
                queue.add(rightNode);
            }
            
            index++;
            
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));