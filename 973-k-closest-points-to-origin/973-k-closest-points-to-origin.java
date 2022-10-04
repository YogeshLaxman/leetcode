class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // return kClosestMinPQ(points, k);
        return kClosestMaxPQ(points, k);
    }
    
    // min priority queue - (nlogn)
    private int[][] kClosestMinPQ(int[][] points, int k) {
        int[][] result = new int[k][];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int distance1 = a[0] * a[0] + a[1] * a[1];
            int distance2 = b[0] * b[0] + b[1] * b[1];
            return distance1 - distance2;
        });
        
        for (int[] point: points) {
            pq.add(point);
        }
        
        for (int i=0; i<k; i++) {
            result[i] = pq.poll();
        }
        
        return result;
    }
    
    // max prriority queue - (nlogk)
    private int[][] kClosestMaxPQ(int[][] points, int k) {
        int[][] result = new int[k][];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int distance1 = a[0] * a[0] + a[1] * a[1];
            int distance2 = b[0] * b[0] + b[1] * b[1];
            return distance2 - distance1;
        });
        
        for (int[] point: points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        for (int i=0; i<k; i++) {
            result[i] = pq.poll();
        }
        
        return result;
    }
    
    private int[][] kClosestQuickSelect(int[][] points, int k) {
        return null;
    }
}