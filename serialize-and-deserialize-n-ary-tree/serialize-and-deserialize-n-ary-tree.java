/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        sb.append(root.val).append(";");
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            List<Node> children = node.children;
            if (children == null) {
                continue;
            }
            if (children.size() > 0) {
                Node child = children.get(0);
                sb.append(child.val);
                q.add(child);
            }
            for (int i=1; i<children.size(); i++) {
                Node child = children.get(i);
                sb.append(",").append(child.val);
                q.add(child);
            }
            sb.append(";");
        }
        // System.out.println(sb);
        return sb.toString();
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] split = data.split(";");
        if (split.length == 0 || split[0].equals("")) {
            return null;
        }
        Node root = new Node(Integer.parseInt(split[0]), new ArrayList<>());
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int k = 1;
        while(!q.isEmpty()) {
            Node parent = q.poll();
            if (k>=split.length || split[k].equals("")) {
                k++;
                continue;
            }
            String[] childSplit = split[k++].split(",");
            for (String child: childSplit) {
                Node node = new Node(Integer.parseInt(child), new ArrayList<>());
                q.add(node);
                parent.children.add(node);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));