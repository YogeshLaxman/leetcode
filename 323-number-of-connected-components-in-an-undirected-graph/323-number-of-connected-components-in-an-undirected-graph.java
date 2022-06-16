class Solution {
    public int countComponents(int n, int[][] edges) {
        int numComponents = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n]; 
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                numComponents++;
                visited[i] = true;
                dfs(adjList, visited, i);
            }
        }
        
        return numComponents;
    }
    
    private void dfs(List<List<Integer>> adjList, boolean[] visited, int i) {
        
        for (int neighbor: adjList.get(i)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                dfs(adjList, visited, neighbor);
            }
        }
    }
}