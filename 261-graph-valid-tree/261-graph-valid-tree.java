class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        
        Set<Integer> notVisited = new HashSet<>();
        for (int i=0; i<n; i++) {
            notVisited.add(i);
            adjList.put(i, new HashSet<>());
        }
        
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        notVisited.remove(0);
        
        while (!queue.isEmpty()) {
            int nextNode = queue.poll();
            
            for (int neighbor: adjList.get(nextNode)) {
                if (notVisited.contains(neighbor)) {
                    notVisited.remove(neighbor);
                    queue.add(neighbor);
                    adjList.get(neighbor).remove(nextNode);
                } else {
                    return false;
                }
            }
        }
        
        return notVisited.isEmpty();
    }
}