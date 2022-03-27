/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return cloneGraph(node, new HashMap<Integer, Node>());
    }
    
    public Node cloneGraph(Node node, Map<Integer, Node> nodeMap) {
        int value = node.val;
        
        Node cloneNode = new Node(node.val);
        nodeMap.put(node.val, cloneNode);
        for (Node adj: node.neighbors) {
            if (nodeMap.containsKey(adj.val)) {
                cloneNode.neighbors.add(nodeMap.get(adj.val));
            } else {
                cloneNode.neighbors.add(cloneGraph(adj, nodeMap));
            }
        }
        
        return cloneNode;
    }
}