class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;
        
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        
        for (int i=0; i<n; i++) {
            adjList.put(i, new HashSet<>());
        }
        
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        
        while (!queue.isEmpty()) {
            int nextNode = queue.poll();
            
            for (int neighbor: adjList.get(nextNode)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        
        return visited.size() == n;
    }
}