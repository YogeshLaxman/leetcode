class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<List<Pair<Integer, Integer>>> adjList = new ArrayList<>();
        
        for (int i=0; i<values.length; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int value = edge[2];
            
            adjList.get(u).add(new Pair(v, value));
            adjList.get(v).add(new Pair(u, value));
        }
        
        Set<Integer> set = new HashSet<>();
        set.add(0);
        return maximalPathQuality(values, adjList, maxTime, 0, values[0], set);
    }
    
    private int maximalPathQuality(int[] values, 
                                   List<List<Pair<Integer, Integer>>> adjList, 
                                   int remTime, 
                                   int currentIndex, 
                                   int currentAns,
                                  Set<Integer> set) {
        int ans = 0;
        
        if (currentIndex == 0) {
            // System.out.println(currentAns + ":" + remTime);
            ans = currentAns;
        }
        
        for (Pair<Integer, Integer> next : adjList.get(currentIndex)) {
            int dest = next.getKey();
            int time = next.getValue();
            
            if (remTime >= time) {
                if (set.contains(dest)) {
                    ans = Math.max(ans, maximalPathQuality(values, adjList, remTime - time, dest, currentAns, set));    
                } else {
                    set.add(dest);
                    ans = Math.max(ans, maximalPathQuality(values, adjList, remTime - time, dest, currentAns + values[dest], set));    
                    set.remove(dest);
                }
                
            }
        }
        
        return ans;
    }
}