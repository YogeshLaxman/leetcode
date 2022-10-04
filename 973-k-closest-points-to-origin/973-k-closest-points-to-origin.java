class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // return kClosestMinPQ(points, k);
        // return kClosestMaxPQ(points, k);
        return kClosestQuickSelect(points, k);
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
        quickSelect(points, k-1, 0, points.length-1);
        
        int[][] result = new int[k][];
        for (int i=0; i<k; i++) {
            result[i] = points[i];
        }
        return result;
    }
    
    private void quickSelect(int[][] points, int k, int low, int high) {
        int index = findPivot(points, low, high);
        
        if (index == k) return;
        
        if (k < index) {
            quickSelect(points, k, low, index-1);
        } else {
            quickSelect(points, k, index+1, high);
        }
    }
    
    private int findPivot(int[][] points, int low, int high) {
        int i = low, j = low+1;
        
        while (j <= high) {
            if (distance(points[j]) <= distance(points[low])) {
                swap(points, i+1, j);
                i++;
            }
            j++;
        }
        swap(points, i, low);
        
        return i;
    }
    
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    private void swap(int[][] points, int index1, int index2) {
        // System.out.println(index1 + ":" + index2);
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}