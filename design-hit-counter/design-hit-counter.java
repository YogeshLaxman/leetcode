class HitCounter {
    Map<Integer, Integer> countMap;
    /** Initialize your data structure here. */
    public HitCounter() {
        countMap = new HashMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        countMap.put(timestamp, countMap.getOrDefault(timestamp, 0) + 1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int startTime = Math.max(0, timestamp-299);
        
        int sum = 0;
        for(int i=startTime; i<=timestamp; i++) {
            sum += countMap.getOrDefault(i, 0);
        }
        
        return sum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */