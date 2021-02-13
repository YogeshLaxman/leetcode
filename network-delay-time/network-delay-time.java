class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjecencyList = new HashMap<>();
        
        for (int[] edge: times) {
            if (!adjecencyList.containsKey(edge[0])) {
                adjecencyList.put(edge[0], new ArrayList<>());
            }
            adjecencyList.get(edge[0]).add(edge);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Map<Integer, int[]> map = new HashMap<>();
        
        for (int i=1; i<=n; i++) {
            int[] item = new int[2];
            item[0] = i;
            if (i == k) {
                item[1] = 0;    
            } else {
                item[1] = Integer.MAX_VALUE;  
            }
            map.put(i, item);
            pq.add(item);
        }
        
        Set<Integer> seen = new HashSet<>();
        
        int max = 0;
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            if (next[1] == Integer.MAX_VALUE) {
                continue;
            }
            
            seen.add(next[0]);
            max = Math.max(max, next[1]);
            
            for (int[] edge: adjecencyList.getOrDefault(next[0], new ArrayList<>())) {
                int d = edge[1];
                if (!seen.contains(d)) {
                    int[] item = map.get(d);
                    if (item[1] > next[1] + edge[2]) {
                        pq.remove(item);
                        item[1] = next[1] + edge[2];
                        pq.add(item);
                    }
                }
                
            }
        }
        
        return seen.size() == n ? max : -1;
    }
}