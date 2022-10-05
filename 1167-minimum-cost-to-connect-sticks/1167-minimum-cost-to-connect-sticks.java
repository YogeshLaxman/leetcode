class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int stick: sticks) {
            pq.add(stick);
        }
        
        int ans = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            
            int current = first + second;
            ans += current;
            pq.add(current);
        }
        
        return ans;
    }
}