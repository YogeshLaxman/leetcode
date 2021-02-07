class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y-x);
        pq.add(a); pq.add(b); pq.add(c);
        
        int maxScore = 0;
        while(true) {
            if (pq.size() >= 2) {
                int x = pq.poll();
                int y = pq.poll();
                maxScore++;
                x--;
                y--;
                if (x > 0) {
                    pq.add(x);
                }
                if (y > 0) {
                    pq.add(y);
                }
            } else {
                break;
            }
        }
        return maxScore;
    }
}