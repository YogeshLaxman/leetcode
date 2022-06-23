class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            if (pq.size() < k) {
                pq.add(entry);
            } else {
                Map.Entry<Integer, Integer> min = pq.peek();
                if (min.getValue() < entry.getValue()) {
                    pq.poll();
                    pq.add(entry);
                }
            }
        }
        
        int[] ans = new int[k];
        
        for (int i=k-1; i>=0; i--) {
            ans[i] = pq.poll().getKey();
        }
        
        return ans;
    }
}