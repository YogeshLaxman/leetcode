class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adjList = new HashMap<>();
        
        for (int i=0; i<equations.size(); i++) {
            String x = equations.get(i).get(0);
            if (!adjList.containsKey(x)) {
                 adjList.put(x, new HashMap<>());  
            }
            
            String y = equations.get(i).get(1);
            if (!adjList.containsKey(y)) {
                 adjList.put(y, new HashMap<>());  
            }
            
            double value = values[i];
            
            adjList.get(x).put(y, value);
            adjList.get(y).put(x, 1.0 / value);
        }
        
        // System.out.println(adjList);
        
        int qSize = queries.size();
        double[] ans = new double[qSize];
        
        for (int i=0; i < qSize; i++) {
            String x = queries.get(i).get(0);
            if (!adjList.containsKey(x)) {
                 ans[i] = -1;
                continue;
            }
            String y = queries.get(i).get(1);
            if (!adjList.containsKey(y)) {
                 ans[i] = -1;
                continue;
            }
            
            Set<String> seen = new HashSet<>();
            seen.add(x);
            double currentAns = dfs(adjList, x, y, seen, 1.0);
            ans[i] = currentAns;
        }
        
        return ans;
    }
    
    private double dfs(Map<String, Map<String, Double>> adjList, String currentString, String targetString, Set<String> seen, double currentAns) {
        // System.out.println(currentString + ":" + targetString + ":" + currentAns);
        if (currentString.equals(targetString)) {
            return currentAns;
        }
        
        Map<String, Double> neighbors = adjList.get(currentString);
        
        for (Map.Entry<String, Double> n : neighbors.entrySet()) {
            if (!seen.contains(n.getKey())) {
                seen.add(n.getKey());
                double possibleAns = dfs(adjList, n.getKey(), targetString, seen, currentAns * n.getValue());
                if (possibleAns != -1) {
                    return possibleAns;
                }
            }
        }
        
        return -1;
    }
}