class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> inBound = new HashMap<>();
        Map<Integer, List<Integer>> outBound = new HashMap<>();
        
        for (int[] connection: connections) {
            int src = connection[0];
            int dest = connection[1];
            
            if (!outBound.containsKey(src)) {
                outBound.put(src, new ArrayList<>());
            }
            outBound.get(src).add(dest);
            
            if (!inBound.containsKey(dest)) {
                inBound.put(dest, new ArrayList<>());
            }
            inBound.get(dest).add(src);
        }
        // System.out.println(outBound);
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q.add(0);
        int count = 0;
        while (!q.isEmpty()) {
            int next = q.poll();
            seen.add(next);
            List<Integer> inBountList = inBound.getOrDefault(next, new ArrayList<>());
            for (int in: inBountList) {
                if (!seen.contains(in)) {
                    q.add(in);
                }
            }
            List<Integer> outBoundList = outBound.getOrDefault(next, new ArrayList<>());
            for (int out: outBoundList) {
                if (!seen.contains(out)) {
                    q.add(out);
                    count++;
                }
            } 
        }
        
        return count;
    }
}