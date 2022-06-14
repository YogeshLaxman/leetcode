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
        
        Map<Node, Node> cloneMap = new HashMap<>();
        
        Node cloneNode = new Node(node.val);
        cloneMap.put(node, cloneNode);
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        
        while(!queue.isEmpty()) {
            Node pollNode = queue.poll();
            Node clonePollNode = cloneMap.get(pollNode);
                
            for (Node neighbor: pollNode.neighbors) {
                if (cloneMap.containsKey(neighbor)) {
                    clonePollNode.neighbors.add(cloneMap.get(neighbor));
                } else {
                    
                    Node newNode = new Node(neighbor.val);
                    cloneMap.put(neighbor, newNode);
                    
                    clonePollNode.neighbors.add(newNode);
                    queue.add(neighbor);
                }
            }
        }
        
        return cloneNode;
    }
}